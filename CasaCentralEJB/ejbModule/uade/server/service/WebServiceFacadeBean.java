package uade.server.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import uade.server.CasaCentral;
import uade.server.CasaCentralBean;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.xml.Palc;
import uade.server.exception.CasaCentralException;
import uade.server.service.xml.util.XMLParser;

@WebService(name = "CasaCentralService", targetNamespace = "http://www.uade.edu.ar/casacentral", serviceName = "CasaCentralWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)  
@Stateless
public class WebServiceFacadeBean implements WebServiceFacade {
	
	private static final Logger logger = Logger.getLogger(WebServiceFacadeBean.class);

	@EJB
	private CasaCentral casaCentral;

	/**
	 * TODO: La otra llamada via webservice la tenemos que emitir hacia el
	 * Centro de distribucion. De alguna manera, el operador, via la web va a
	 * decir "generar soldist". Eso va a disparar un proceso que la generara y
	 * inmediatamente despoues levantara todos los centros de distribución y
	 * enviara por webservice soap la soldist a cada uno.
	 * 
	 */

	/**
	 * This method must be called by a Shop
	 */
	@WebMethod
	public void ingresarPredido(@WebParam(name="xml") String xml) {
		try {
			logger.info("Pedido recibido: " + xml);
			Palc pedido = (Palc) XMLParser.parseObject(xml);

			TiendaDTO t = new TiendaDTO();
			t.setId(Long.valueOf(pedido.getIdTienda()));

			casaCentral.ingresarPredido(pedido, t);
		} catch (CasaCentralException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public void setCasaCentral(CasaCentral casaCentral) {
		this.casaCentral = casaCentral;
	}
}
