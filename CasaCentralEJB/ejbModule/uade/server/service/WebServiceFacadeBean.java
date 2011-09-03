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

@Stateless @WebService
public class WebServiceFacadeBean implements WebServiceFacade {

	@EJB
	private CasaCentral casaCentral;
	
	
	/* (non-Javadoc)
	 * @see uade.server.service.WebServiceFacade#ingresarPredido(uade.server.beans.dto.xml.Palc, uade.server.beans.dto.TiendaDTO)
	 */
	@WebMethod
	public PedidoDTO ingresarPredido(Palc pedido, TiendaDTO tienda) throws CasaCentralException {
		return casaCentral.ingresarPredido(pedido, tienda);
	}

	
	public void setCasaCentral(CasaCentral casaCentral) {
		this.casaCentral = casaCentral;
	}
	
}
