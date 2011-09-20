package uade.server;

import java.util.List;

import javax.ejb.EJB;

import org.apache.log4j.Logger;

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

public class ServicesManagerBean implements ServicesManager{

	private static final Logger logger = Logger.getLogger(CasaCentralBean.class);
	private static final boolean SERVICE_ENABLED = true;
	
	@EJB
	private JMSManager jmsManager;
	@EJB
	private SOAPManager wsManager;
	@EJB
	private NuevoArtAdministrator articuloAdministrator;
	
	public void enviarNuevoArtHogarJMS(ArticuloHogarDTO a, List<CentroDistribucion> centros) {
		if (SERVICE_ENABLED) {
			String xml = XMLParser.parse(new NuevoartHogar(a));
			jmsManager.enviarMensajeFabrica(xml);
			for (CentroDistribucion centro : centros) {
				jmsManager.enviarMensajeACentroDistribucion(xml, centro);
			}
		}
	}
	
	public void enviarNuevoArtRopaJMS(ArticuloRopaDTO a, List<CentroDistribucion> centros) {
		if (SERVICE_ENABLED) {
			String xml = XMLParser.parse(new NuevoartRopa(a));
			jmsManager.enviarMensajeFabrica(xml);
			for (CentroDistribucion centro : centros) {
				jmsManager.enviarMensajeACentroDistribucion(xml, centro);
			}
		}
	}
	
	public void enviarSolicitudesDistribucionWS(List<SolDistDTO> r) {
		if (SERVICE_ENABLED) {
			for (SolDistDTO sd : r) {
				Soldist xmlDto = XmlMapper.mapSolDistXml(sd);
				CentroDistribucion cd = this.articuloAdministrator.obtenerCentroDistribucion(sd.getCentroDistribucion().getId());				
				wsManager.enviarSolicitudDistribucion(XMLParser.parse(xmlDto), cd);
			}
		}
	}
	
	public void enviarOfadJMS(String xml, List<Tienda> tiendas) {
		if (SERVICE_ENABLED) { 
			for (Tienda t : tiendas) {
				if (t.getJmsConnectionString() != null && !t.getJmsConnectionString().trim().equalsIgnoreCase("")) {
					jmsManager.enviarOfadATienda(xml, t);
				}
			}
		}
	}
}
