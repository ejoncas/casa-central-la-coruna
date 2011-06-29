package uade.web.servlets; 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;
import uade.web.xml.util.XMLParser;

/**
 * Servlet implementation class for Servlet: Ofad
 *
 */
 public class Ofad extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static final String OFAD_PAGE = "/WEB-INF/jsp/ofad.jsp";
   private static final String INDEX_PAGE = "/index.jsp";
   
   public static String ACTION_ADD = "ADD";
   public static String ACTION_DEL = "DEL";
   public static String ACTION_GENERATE = "GEN";
   public static String ACTION_DISCARD = "DIS";
   
	public Ofad() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//reset the session
			request.getSession().invalidate();
			
			//Required Content to render view
			CasaCentralDelegator casaCentralDelegator = CasaCentralDelegator.getInstance();
			
			uade.server.beans.dto.xml.Ofad ofertas =  casaCentralDelegator.obtenerOfad();
			
			List<ArticuloDTO> articulo = casaCentralDelegator.obtenerArticulos();
			
			request.getSession().setAttribute("articulos", articulo);
			request.getSession().setAttribute("ofertas", ofertas);
		} 
		catch (WebApplicationException e) {e.printStackTrace();} 
		catch (CasaCentralException e) {e.printStackTrace();}
		//FORWARD
		getServletContext().getRequestDispatcher(OFAD_PAGE).forward(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ACTION_ADD.equalsIgnoreCase(request.getParameter("action"))){
			//ADD Item by code
			try {
				String idArticulo = request.getParameter("art-id");
				
				uade.server.beans.dto.xml.Ofad oferta = (uade.server.beans.dto.xml.Ofad) request.getSession().getAttribute("ofertas");
				
				//la actualizamos con el nuevo item agregado
				ArticuloDTO art = CasaCentralDelegator.getInstance().agregarOfad(oferta, Long.valueOf(idArticulo));
				if(art instanceof ArticuloRopaDTO){
					oferta.addArticuloRopa((ArticuloRopaDTO) art);
				}else if(art instanceof ArticuloHogarDTO){
					oferta.addArticuloHogar((ArticuloHogarDTO) art);
				}
				request.getSession().setAttribute("ofertas", oferta);
				
				//FORWARD
				getServletContext().getRequestDispatcher(OFAD_PAGE).forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (WebApplicationException e) {
				e.printStackTrace();
			} catch (CasaCentralException e) {
				e.printStackTrace();
			}
		}else if(ACTION_DEL.equalsIgnoreCase(request.getParameter("action"))){
			try {
				String idArticulo = request.getParameter("art-id");

				uade.server.beans.dto.xml.Ofad oferta = (uade.server.beans.dto.xml.Ofad) request.getSession().getAttribute("ofertas");
				
				ArticuloDTO artEliminado = CasaCentralDelegator.getInstance().eliminarArtOfad(oferta, idArticulo);
				
				oferta.getAccesoriosHogar().remove(artEliminado);
				oferta.getRopa().remove(artEliminado);

				request.getSession().setAttribute("ofertas", oferta);
				
				//FORWARD
				getServletContext().getRequestDispatcher(OFAD_PAGE).forward(request, response);
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (CasaCentralException e) {
				e.printStackTrace();
			} catch (WebApplicationException e) {
				e.printStackTrace();
			}
		}else if(ACTION_GENERATE.equalsIgnoreCase(request.getParameter("action"))){
			uade.server.beans.dto.xml.Ofad oferta = (uade.server.beans.dto.xml.Ofad) request.getSession().getAttribute("ofertas");
			//TODO - Generate XML (it is supposed that its already saved)
			
			String xml = XMLParser.parse(oferta);
			
			response.getWriter().write(xml);
		}else if(ACTION_DISCARD.equalsIgnoreCase(request.getParameter("action"))){
			try {
				uade.server.beans.dto.xml.Ofad oferta = (uade.server.beans.dto.xml.Ofad) request.getSession().getAttribute("ofertas");
	
				//TODO - Delete offer from database
				CasaCentralDelegator.getInstance().eliminarOfad(oferta);
				
				//FORWARD
				getServletContext().getRequestDispatcher(INDEX_PAGE).forward(request, response);
			} catch (CasaCentralException e) {
				e.printStackTrace();
			} catch (WebApplicationException e) {
				e.printStackTrace();
			}
		}
	}   	  	    
}