package uade.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uade.server.beans.dto.EnvioDTO;
import uade.server.beans.dto.ItemPedidoDTO;
import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.SolDistDTO;
import uade.server.beans.dto.xml.ItemPedidoXml2DTO;
import uade.server.beans.dto.xml.Soldist;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;
import uade.web.xml.util.XMLParser;

/**
 * Servlet implementation class for Servlet: DownloadXml
 *
 */
 public class DownloadXml extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public DownloadXml() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idSoldist = request.getParameter("id");
			
			CasaCentralDelegator casaCentralDelegator = CasaCentralDelegator.getInstance();
			
			SolDistDTO sd = casaCentralDelegator.obtenerSolicitudDistribucion(Long.valueOf(idSoldist));
			
			
			Soldist soldistXml = mapSolDistXml(sd);
			
			
			
			
			String xml = XMLParser.parse(soldistXml);
			
			response.getWriter().write(xml);
			
		} 
		catch (WebApplicationException e) {e.printStackTrace();} 
		catch (CasaCentralException e) {e.printStackTrace();}
	}  	
	
	private Soldist mapSolDistXml(SolDistDTO sd) {
		Soldist xml = new Soldist();
		xml.setNumSolDist(sd.getId());
		List<EnvioDTO> envios = new ArrayList<EnvioDTO>();
		for(PedidoDTO p : sd.getPedidosAEntregar()){
			EnvioDTO e = new EnvioDTO();
			e.setIdTienda(p.getTienda().getId());
			List<ItemPedidoXml2DTO> items = new ArrayList<ItemPedidoXml2DTO>();
			for(ItemPedidoDTO ipDto : p.getItems()){
				ItemPedidoXml2DTO itemDto = new ItemPedidoXml2DTO();
				itemDto.setRef(ipDto.getArticulo().getReferencia().toString());
				itemDto.setCant(ipDto.getCantidad());
				items.add(itemDto);
			}
			e.setPedidos(items);
			envios.add(e);
		}
		xml.setEnvios(envios);
		return xml;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}   	  	    
}