package uade.server.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import uade.server.CasaCentral;
import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.xml.Palc;
import uade.server.exception.CasaCentralException;
import uade.server.service.xml.util.XMLParser;

@Stateless @WebService
public class WebServiceFacadeBean implements WebServiceFacade {

	@EJB
	private CasaCentral casaCentral;
	
	/**
	 * TODO: La otra llamada via webservice la tenemos que emitir hacia
	 * el Centro de distribucion.
	 * De alguna manera, el operador, via la web va a decir "generar soldist".
	 * Eso va a disparar un proceso que la generara y inmediatamente despoues
	 * levantara todos los centros de distribución y enviara por webservice soap
	 * la soldist a cada uno.
	 *  
	 */
	
	/**
	 * This method must be called by a Tent
	 */
	@WebMethod 
	public PedidoDTO ingresarPredido(String xml) throws CasaCentralException {
		
		Palc pedido = (Palc) XMLParser.parseObject(xml);
		
		TiendaDTO t = new TiendaDTO();
		{
			t.setId(Long.valueOf(pedido.getIdTienda()));
		}
		
		return casaCentral.ingresarPredido(pedido, t);
	}

	
	public void setCasaCentral(CasaCentral casaCentral) {
		this.casaCentral = casaCentral;
	}
}
