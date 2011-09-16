package uade.server.service.client;

import javax.ejb.Local;

import uade.server.beans.CentroDistribucion;

@Local
public interface SOAPManager {

	void enviarSolicitudDistribucion(String text, CentroDistribucion cd);

}