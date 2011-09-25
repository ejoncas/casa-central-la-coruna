package uade.server.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang.StringUtils;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.SolDistDTO;
import uade.server.beans.dto.xml.NuevoartHogar;
import uade.server.beans.dto.xml.NuevoartRopa;
import uade.server.beans.dto.xml.Soldist;
import uade.server.modules.NuevoArtAdministrator;
import uade.server.service.client.JMSManager;
import uade.server.service.client.SOAPManager;
import uade.server.service.xml.util.XMLParser;
import uade.server.service.xml.util.XmlMapper;

@Stateless
public class ServicesManagerBean implements ServicesManager{

	/**
	 * FLAGS to enabled/disable ws by modules.
	 */
	private static final boolean FABRICA_ENABLED = true;
	/*
	 * Ofad Probada:
	 * 		TIENDA - DIBELLO
	 * 		TIENDA - MAJTAN
	 */
	private static final boolean TIENDA_ENABLED = true;
	/*
	 * Nuevo articulo Probado:
	 * 		CD - MATTAR
	 * 		FABRICA - DOGHEL
	 * 		
	 */
	private static final boolean CENTRO_DISTRIBUCION_ENABLED = true;
	
	
	/**
	 * EJB services needed.
	 */
	@EJB
	private JMSManager jmsManager;
	@EJB
	private SOAPManager soapManager;
	@EJB
	private NuevoArtAdministrator articuloAdministrator;
	
	
	
	public void enviarNuevoArtHogarJMS(ArticuloHogarDTO a, List<CentroDistribucion> centros) {
		String xml = XMLParser.parse(new NuevoartHogar(a));
		notificarMensajeNuevoArticulo(centros, xml);
	}

	public void enviarNuevoArtRopaJMS(ArticuloRopaDTO a, List<CentroDistribucion> centros) {
		final String xml = XMLParser.parse(new NuevoartRopa(a));
		notificarMensajeNuevoArticulo(centros, xml);
	}
	
	private void notificarMensajeNuevoArticulo(
			List<CentroDistribucion> centros, String xml) {
		if (FABRICA_ENABLED) {
			new Thread(new EnviarMensajeFabricaRunnable(xml)).start();
			//jmsManager.enviarMensajeFabrica(xml);
		}
		if (CENTRO_DISTRIBUCION_ENABLED) { 
			for (CentroDistribucion centro : centros) {
				if (StringUtils.isNotEmpty(centro.getJmsConnectionString()) && StringUtils.isNotEmpty(centro.getQueueName())) {
//				if (centro.getJmsConnectionString() != null && centro.getQueueName() !=null) {
					new Thread(new EnviarMensajeACentroDistribucionRunnable(xml, centro)).start();
					//jmsManager.enviarMensajeACentroDistribucion(xml, centro);
				}
			}
		}
	}
	
	public void enviarSolicitudesDistribucionWS(List<SolDistDTO> r) {
		if (CENTRO_DISTRIBUCION_ENABLED) {
			for (SolDistDTO sd : r) {
				Soldist xmlDto = XmlMapper.mapSolDistXml(sd);
				String xml = XMLParser.parse(xmlDto);
				CentroDistribucion cd = this.articuloAdministrator.obtenerCentroDistribucion(sd.getCentroDistribucion().getId());
				if (cd.getEndpoint() != null) {
					new Thread(new EnviarSolicitudDistribucionRunnable(xml, cd)).start();
					//soapManager.enviarSolicitudDistribucion();
				}
			}
		}
	}
	
	public void enviarOfadJMS(String xml, List<Tienda> tiendas) {
		if (TIENDA_ENABLED) { 
			for (Tienda t : tiendas) {
				if (StringUtils.isNotEmpty(t.getJmsConnectionString()) 
						&& StringUtils.isNotEmpty(t.getQueueName())) { 
				//if (t.getJmsConnectionString()!= null && t.getQueueName()!=null) {
					new Thread(new EnviarOfadATienda(xml, t)).start();
					//jmsManager.enviarOfadATienda(xml, t);
				}
			}
		}
	}
	
	
	/*
	 * Inner Classes to call services inside threads. 
	 */
	
	
	/**
	 * Clase que nos permite enviar request de forma no bloqueante a la Fabrica
	 * via JMS.
	 * 
	 */
	class EnviarMensajeFabricaRunnable implements Runnable {
		private String xml;
		public EnviarMensajeFabricaRunnable(String xml) {
			this.xml = xml;
		}
		public void run() {
			System.out.println("EnviarMensajeFabricaRunnable.run()");
			jmsManager.enviarMensajeFabrica(this.xml);
		}
	}
	
	/**
	 * Clase para enviar pedidos de forma no bloqueante a los centros de distribucio
	 * via JMS. Caso Nuevo articulo
	 */
	class EnviarMensajeACentroDistribucionRunnable implements Runnable {
		private String xml;
		private CentroDistribucion centro;
		
		public EnviarMensajeACentroDistribucionRunnable(String xml, CentroDistribucion centro) {
			this.xml = xml;
			this.centro = centro;
		}

		public void run() {
			System.out.println("EnviarMensajeACentroDistribucionRunnable.run()");
			jmsManager.enviarMensajeACentroDistribucion(xml, centro);
		}
	}
	
	/**
	 *  Clase para enviar pedidos de forma no bloqueante a los centros de distribucio
	 *  via Soap WS. Caso generar solicitud de distribucion
	 */
	class EnviarSolicitudDistribucionRunnable implements Runnable {
		private String xml;
		private CentroDistribucion centro;
		
		public EnviarSolicitudDistribucionRunnable(String xml,
				CentroDistribucion centro) {
			super();
			this.xml = xml;
			this.centro = centro;
		}


		public void run() {
			System.out.println("EnviarSolicitudDistribucionRunnable.run()");
			soapManager.enviarSolicitudDistribucion(xml, centro);
		}
		
	}
	
	/**
	 * Clase para enviar pedidos de forma no bloqueante a las tiendas
	 * via JMS. Caso OFAD
	 */
	class EnviarOfadATienda implements Runnable {

		private String xml;
		private Tienda tienda;
		
		public EnviarOfadATienda(String xml, Tienda tienda) {
			super();
			this.xml = xml;
			this.tienda = tienda;
		}

		public void run() {
			System.out.println("EnviarOfadATienda.run()");
			jmsManager.enviarOfadATienda(xml, tienda);
		}
	}
	
}
