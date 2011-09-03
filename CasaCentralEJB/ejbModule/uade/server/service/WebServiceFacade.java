package uade.server.service;

import javax.ejb.Remote;

import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.xml.Palc;
import uade.server.exception.CasaCentralException;

@Remote
public interface WebServiceFacade {

	PedidoDTO ingresarPredido(Palc pedido, TiendaDTO tienda)
			throws CasaCentralException;

}