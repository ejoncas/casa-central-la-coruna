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
 * Servlet implementation class for Servlet: Articulos
 *
 */
 public class Articulos extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static final String ARTICULOS_PAGE = "/WEB-INF/jsp/articulos.jsp";
   
   
	public Articulos() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CasaCentralDelegator bussinessDelegator = CasaCentralDelegator.getInstance();
			
			List<ArticuloDTO> articulos =  bussinessDelegator.obtenerArticulos();
			
			request.setAttribute("articulos", articulos);
			//FORWARD
			getServletContext().getRequestDispatcher(ARTICULOS_PAGE).forward(request, response);
		} catch (WebApplicationException e) {
			e.printStackTrace();
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}   	  	    
}