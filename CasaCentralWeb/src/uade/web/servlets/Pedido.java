package uade.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Pedido
 *
 */
 public class Pedido extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static final String PEDIDO_PAGE = "/WEB-INF/jsp/palc.jsp";
   
	public Pedido() {
		super();
	}   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FORWARD
		getServletContext().getRequestDispatcher(PEDIDO_PAGE).forward(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}   	  	    
}