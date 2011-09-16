package uade.server.service.client;

import javax.ejb.Local;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;

@Local
public interface JMSManager {

	void enviarMensajeFabrica(String text);

	void enviarOfadATienda(String text, Tienda tienda);

	void enviarMensajeACentroDistribucion(String xml,
			CentroDistribucion cd);

}