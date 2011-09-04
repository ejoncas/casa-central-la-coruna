package uade.server.service;

import javax.ejb.Remote;

import uade.server.beans.dto.PedidoDTO;
import uade.server.exception.CasaCentralException;

@Remote
public interface WebServiceFacade {

	PedidoDTO ingresarPredido(String xml) throws CasaCentralException;

}