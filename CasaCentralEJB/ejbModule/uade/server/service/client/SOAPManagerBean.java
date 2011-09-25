package uade.server.service.client;

import java.rmi.RemoteException;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uade.server.beans.CentroDistribucion;
import ws.RecibirSolDistWSProxy;

@Stateless
public class SOAPManagerBean implements SOAPManager {

	private final static Logger logger = LoggerFactory.getLogger(JMSManagerBean.class);
	
	
	public void enviarSolicitudDistribucion(String xml, CentroDistribucion cd) {
		System.out.println("SOAPManagerBean.enviarSolicitudDistribucion() \nXML: " + xml);
		try {
				RecibirSolDistWSProxy proxy = new RecibirSolDistWSProxy();
				if (StringUtils.isNotEmpty(cd.getEndpoint())) {
					proxy.setEndpoint(cd.getEndpoint());
				}
				boolean result = proxy.recibirSolDist(xml);
				if (result) {
					logger.debug("Soldist enviada correctamente a CD [" + cd.getNombre() + "] - ENDPOINT: " + proxy.getEndpoint());
				} else {
					logger.error("Error al enviar la solidst a CD [" + cd.getNombre() + "] - ENDPOINT: " + proxy.getEndpoint());
				}
					
		} 
		catch (RemoteException e) {e.printStackTrace();}
	}

}
