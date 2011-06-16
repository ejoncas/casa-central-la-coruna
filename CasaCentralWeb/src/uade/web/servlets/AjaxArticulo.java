package uade.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;

/**
 * Servlet implementation class for Servlet: AjaxArticulo
 *
 */
 public class AjaxArticulo extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public AjaxArticulo() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type= request.getParameter("type");
		String msg = new String();
		CasaCentralDelegator bussinesDelegator;
		try {
			bussinesDelegator = CasaCentralDelegator.getInstance();
			if("R".equalsIgnoreCase(type)){
				//Type Ropa
				ArticuloRopaDTO a = new ArticuloRopaDTO();
				
				a.setColor(request.getParameter("color"));
				a.setDescripcion(request.getParameter("desc"));
				a.setLinea(request.getParameter("linea"));
				a.setOrigen(request.getParameter("origen"));
				if(StringUtils.isNotEmpty(request.getParameter("precio")))
					a.setPrecio(new Float(request.getParameter("precio")));
				a.setSeccion(request.getParameter("seccion"));
				a.setTalle(request.getParameter("talle"));
				
				a = bussinesDelegator.nuevoArtRopa(a);
				
				//TODO - Generate Xml
				msg = "Se ha cread el articulo de ropa. #REF "+a.getReferencia();
			}else if("H".equalsIgnoreCase(type)){
				//Type Hogar
				ArticuloHogarDTO a = new ArticuloHogarDTO();
				
				a.setColor(request.getParameter("color"));
				a.setDescripcion(request.getParameter("desc"));
				a.setLinea(request.getParameter("linea"));
				if(StringUtils.isNotEmpty(request.getParameter("precio")))
					a.setPrecio(new Float(request.getParameter("precio")));
				a.setSeccion(request.getParameter("seccion"));
				a.setCategoria(request.getParameter("categoria"));
				a.setComposicion(request.getParameter("composicion"));
				a.setMedidas(request.getParameter("medidas"));
				a.setNombre(request.getParameter("nombre"));
				
				a = bussinesDelegator.nuevoArtCasa(a);
				
				//TODO - Generate Xml
				msg = "Se ha cread el articulo de hogar. #REF "+a.getReferencia();
			}else{
				//unknown type
				msg = "ERROR: No se interpreto el tipo de articulo que se debe crear";
			}			
		} catch (WebApplicationException e1) {
			msg = "ERROR: Imposible obtener la instancia del Servidor. Detalle: "+e1.toString();
		} catch (CasaCentralException e) {
			msg = "ERROR: El servidor ha largado una excepcion al crear el articulo. Detalle: "+e.toString();
		}catch (RuntimeException e) {
			msg = "ERROR: Error mientras se procesaba la informacion. Detalle: "+e.toString();
		}
		//send response
		response.getWriter().write(msg);
	}   	  	    
}