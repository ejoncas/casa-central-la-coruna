package uade.web.servlets; 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;

/**
 * Servlet implementation class for Servlet: Ofad
 *
 */
 public class Ofad extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static final String OFAD_PAGE = "/WEB-INF/jsp/ofad.jsp";
   
	public Ofad() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Required Content to render view
			CasaCentralDelegator casaCentralDelegator = CasaCentralDelegator.getInstance();
			
			
			uade.server.beans.dto.xml.Ofad ofertas =  casaCentralDelegator.obtenerOfad();
			
			List<ArticuloDTO> articulo = casaCentralDelegator.obtenerArticulos();
			
			request.setAttribute("articulos", articulo);
			request.setAttribute("ofertas", ofertas);
			
		} 
		catch (WebApplicationException e) {e.printStackTrace();} 
		catch (CasaCentralException e) {e.printStackTrace();}
		//FORWARD
		getServletContext().getRequestDispatcher(OFAD_PAGE).forward(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}