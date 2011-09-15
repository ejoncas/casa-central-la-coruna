package uade.server.service;

import javax.ejb.Remote;

@Remote
public interface WebServiceFacade {

	void ingresarPredido(String xml);

}