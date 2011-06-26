package uade.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uade.server.beans.dto.SolDistDTO;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;

/**
 * Servlet implementation class for Servlet: SolicitudDistribucion
 *
 */
 public class SolicitudDistribucion extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static final String SOLICITUD_PAGE = "/WEB-INF/jsp/soldist.jsp";
   private static final String SOLICITUD_LOADED_PAGE = "/WEB-INF/jsp/soldist.jsp";
   
	
	public SolicitudDistribucion() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FORWARD
		getServletContext().getRequestDispatcher(SOLICITUD_PAGE).forward(request, response);
	}  	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CasaCentralDelegator casaCentralDelegator = CasaCentralDelegator.getInstance();
			
			List<SolDistDTO> solicitudes = casaCentralDelegator.generarSolicitudDistribucion();
			
			request.setAttribute("solicitudes", solicitudes);
		} catch (WebApplicationException e) {
			e.printStackTrace();
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}
		//FORWARD
		getServletContext().getRequestDispatcher(SOLICITUD_LOADED_PAGE).forward(request, response);
	}
	
}
 