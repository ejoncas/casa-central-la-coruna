package uade.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import uade.server.beans.Articulo;
import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;
import uade.server.beans.CentroDistribucion;
import uade.server.beans.ItemPedido;
import uade.server.beans.Oferta;
import uade.server.beans.Pedido;
import uade.server.beans.SolDist;
import uade.server.beans.Tienda;
import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloHogarOfadDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.ArticuloRopaOfadDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.SolDistDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.mapper.DTOMapper;
import uade.server.beans.dto.xml.ItemPedidoXmlDTO;
import uade.server.beans.dto.xml.NuevoartHogar;
import uade.server.beans.dto.xml.NuevoartRopa;
import uade.server.beans.dto.xml.Ofad;
import uade.server.beans.dto.xml.Palc;
import uade.server.beans.dto.xml.Soldist;
import uade.server.exception.CasaCentralException;
import uade.server.modules.NuevoArtAdministrator;
import uade.server.modules.OfadAdministrator;
import uade.server.modules.PalcAdministrator;
import uade.server.modules.SolDistAdministrator;
import uade.server.service.client.JMSManager;
import uade.server.service.client.SOAPManager;
import uade.server.service.xml.util.XMLParser;
import uade.server.service.xml.util.XmlMapper;


@Stateless
public class CasaCentralBean implements CasaCentral{

	private static final Logger logger = Logger.getLogger(CasaCentralBean.class);
	
	private static final boolean SERVICE_ENABLED = true;
	/**
	 * EJB Modules
	 */
	
	@EJB
	private NuevoArtAdministrator articuloAdministrator;
	@EJB
	private OfadAdministrator ofadAdministrator;
	@EJB
	private PalcAdministrator palcAdministrator;
	@EJB
	private SolDistAdministrator solDistAdministrator;
	
	
	//FIXME Hacer un WebServiceManager que tenga tanto el JMS como el SOAP y extraer todas las llamadas de aca a ese servicio.
	//Ese servicio tendria todos los flags para correr o no un cierto servicio y ademas correria todo en threads para evitar locks.
	
	//private WebServiceManager
	
	/**
	 * JMS Manager
	 */
	@EJB
	private JMSManager jmsManager;
	
	/**
	 * WS Manager
	 */
	@EJB
	private SOAPManager wsManager;
	
	public ArticuloHogarDTO nuevoArtCasa(ArticuloHogarDTO a) throws CasaCentralException {
		logger.info("Creando nuevo articulo de Hogar");
		
		
		ArticuloHogar ah = new ArticuloHogar(a);
		
		List<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		for(CentroDistribucionDTO cdDto : a.getCentros()){
			CentroDistribucion cd = this.articuloAdministrator.obtenerCentroDistribucion(cdDto.getId());
			//CentroDistribucion cd = (CentroDistribucion) DTOMapper.map(cdDto, CentroDistribucion.class);
			centros.add(cd);
		}
		ah.setCentros(centros);
		articuloAdministrator.nuevoArtCasa(ah);
		a.setReferencia(ah.getReferencia());
		
		enviarNuevoArtHogarJMS(a, centros);
		
		logger.info("Articulo Hogar Creado. REF: #"+ah.getReferencia());
		return a;
	}

	private void enviarNuevoArtHogarJMS(ArticuloHogarDTO a, List<CentroDistribucion> centros) {
		if (SERVICE_ENABLED) {
			String xml = XMLParser.parse(new NuevoartHogar(a));
			jmsManager.enviarMensajeFabrica(xml);
			for (CentroDistribucion centro : centros) {
				jmsManager.enviarMensajeACentroDistribucion(xml, centro);
			}
		}
	}

	public ArticuloRopaDTO nuevoArtRopa(ArticuloRopaDTO a) throws CasaCentralException {
		logger.info("Creando nuevo articulo de Ropa");
		
		ArticuloRopa ar = new ArticuloRopa(a);
		List<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		for(CentroDistribucionDTO cdDto : a.getCentros()){
			CentroDistribucion cd = this.articuloAdministrator.obtenerCentroDistribucion(cdDto.getId());
			centros.add(cd);
		}
		ar.setCentros(centros);
		articuloAdministrator.nuevoArtRopa(ar);
		a.setReferencia(ar.getReferencia());
		
		enviarNuevoArtRopaJMS(a, centros);
		logger.info("Articulo Ropa Creado. REF: #"+ar.getReferencia());
		return a;
	}

	private void enviarNuevoArtRopaJMS(ArticuloRopaDTO a, List<CentroDistribucion> centros) {
		if (SERVICE_ENABLED) {
			String xml = XMLParser.parse(new NuevoartRopa(a));
			jmsManager.enviarMensajeFabrica(xml);
			for (CentroDistribucion centro : centros) {
				jmsManager.enviarMensajeACentroDistribucion(xml, centro);
			}
		}
	}

	/** Called by WS **/
	public PedidoDTO ingresarPredido(Palc pedido, TiendaDTO tienda)
			throws CasaCentralException {
		logger.info("Ingresando Pedido");

		Pedido p = new Pedido();
		{
			p.setFechaPedido(new Date());
			//seteamos todos los items
			for(ItemPedidoXmlDTO item : pedido.getPedidos()){
				ItemPedido ip = new ItemPedido();
				ip.setCantidad(item.getCantidad());
				//busco el articulo por referencia --> Debe ser unico
				Articulo art = articuloAdministrator.getArticuloById(Long.valueOf(item.getRef()));
				ip.setArticulo(art);
				ip.setPrecioVenta(art.getPrecio());
				p.addItemPedido(ip);
			}
			p.setProcesado(false);
			p.setTienda(palcAdministrator.getTienda(tienda.getId()));
		}
		palcAdministrator.ingresarPedido(p);
		return new PedidoDTO(p);
	}

	public List<ArticuloDTO> obtenerArticulos() throws CasaCentralException {
		logger.info("Obteniendo todos los articulos");
		List<Articulo> articulos = articuloAdministrator.obtenerArticulos();
		
		List<ArticuloDTO> resultado = new ArrayList<ArticuloDTO>();
		for(Articulo a : articulos){
			resultado.add(a.getDTO());
		}
		return resultado;
	}

	public void eliminarArticulo(Long ref) throws CasaCentralException {
		logger.info("Eliminando articulo con referencia: "+ref);
		articuloAdministrator.eliminarArticulo(ref);
	}

	public List<CentroDistribucionDTO> obtenerCentrosDeDistribucion()
			throws CasaCentralException {
		logger.info("Obteniendo todos los centros de distribucion");
		List<CentroDistribucion> centros = solDistAdministrator.obtenerCentrosDeDistribucion();
		
		List<CentroDistribucionDTO> centrosDto = new ArrayList<CentroDistribucionDTO>();
		for(CentroDistribucion cd : centros){
			centrosDto.add((CentroDistribucionDTO) DTOMapper.map(cd, CentroDistribucionDTO.class));
		}
		return centrosDto;
	}

	public void nuevoCentroDeDistribucion(
			CentroDistribucionDTO centro) throws CasaCentralException {
		logger.info("Insertando Centro de Distribucion");
		CentroDistribucion cd = (CentroDistribucion) DTOMapper.map(centro, CentroDistribucion.class);
		solDistAdministrator.nuevoCentroDeDistribucion(cd);
		centro.setId(cd.getId());
		logger.info("Centro de Distribucion Creado. ID: #"+cd.getId());
	}

	public void nuevaTienda(TiendaDTO t) {
		logger.info("Insertando Tienda");
		Tienda tienda = new Tienda(t);
		palcAdministrator.nuevaTienda(tienda);
		logger.info("Tienda Creada. ID: #"+tienda.getId());
	}

	public List<SolDistDTO> generarSolicitudDistribucion() throws CasaCentralException {
		logger.info("Generando solicitudes de Distribucion");
		List<SolDist> solicitudes = solDistAdministrator.generarSolicitudDistribucion();
		List<SolDistDTO> r = XmlMapper.mapearDto(solicitudes);
		
		enviarSolicitudesDistribucionWS(r);
		
		return r;
	}

	private void enviarSolicitudesDistribucionWS(List<SolDistDTO> r) {
		if (SERVICE_ENABLED) {
			for (SolDistDTO sd : r) {
				Soldist xmlDto = XmlMapper.mapSolDistXml(sd);
				CentroDistribucion cd = this.articuloAdministrator.obtenerCentroDistribucion(sd.getCentroDistribucion().getId());				
				wsManager.enviarSolicitudDistribucion(XMLParser.parse(xmlDto), cd);
			}
		}
	}

	public SolDistDTO obtenerSolicitudDistribucion(Long idSoldist) throws CasaCentralException {
		logger.info("Obteniendo Solicitud de Distribucio. ID #"+idSoldist);
		SolDist soldist = solDistAdministrator.obtenerSolicitudDistribucion(idSoldist);
		return XmlMapper.mapearDto(soldist);
	}

	public Ofad obtenerOfad() throws CasaCentralException {
		Oferta oferta = ofadAdministrator.obtenerOfad();
		Ofad ofads = XmlMapper.mapearOfertasToDto(oferta);
		return ofads;
	}


	public ArticuloDTO obtenerArticulo(Long ref) {
		logger.info("Obteniendo articulo con id #"+ref);
		Articulo articulo = ofadAdministrator.obtenerArticulo(ref);
		return articulo.getDTO();
	}

	public void actualizarOfad(Ofad ofadDto) throws CasaCentralException {
		Oferta oferta = mapearDtoToOferta(ofadDto);
		ofadAdministrator.actualizarOferta(oferta);
	}

	private Oferta mapearDtoToOferta(Ofad ofadDto) {
		Oferta ofad =  new Oferta();
		for(ArticuloHogarOfadDTO art : ofadDto.getAccesoriosHogar()){
			ofad.addArticulo(new ArticuloHogar(art));
		}
		for(ArticuloRopaOfadDTO ropa : ofadDto.getRopa()){
			ofad.addArticulo(new ArticuloRopa(ropa));
		}
		ofad.setId(ofadDto.getId());
		
		return ofad;
	}

	public ArticuloDTO agregarOfad(Ofad oferta, Long artRef)
			throws CasaCentralException {
		Oferta ofer = mapearDtoToOferta(oferta);
		Articulo art = ofadAdministrator.obtenerArticulo(artRef);
		Articulo artAdded = ofadAdministrator.agregarOfad(ofer, art);
		return artAdded.getDTO();
	}

	public ArticuloDTO eliminarArtOfad(Ofad oferta, String idArticulo)
			throws CasaCentralException {
		Oferta ofer = mapearDtoToOferta(oferta);
		Articulo art = ofadAdministrator.obtenerArticulo(Long.valueOf(idArticulo));
		Articulo artDeleted = ofadAdministrator.eliminarArtOfad(ofer, art);
		return artDeleted.getDTO();
	}

	public void eliminarOfad(Ofad oferta) throws CasaCentralException {
		Oferta o = mapearDtoToOferta(oferta);
		ofadAdministrator.eliminarOfad(o);
	}

	public void enviarOfad(Ofad oferta) throws CasaCentralException {
		String xml = XMLParser.parse(oferta);
		
		List<Tienda> tiendas = ofadAdministrator.obtenerTiendas();
		
		enviarOfadJMS(xml, tiendas);
	}

	private void enviarOfadJMS(String xml, List<Tienda> tiendas) {
		if (SERVICE_ENABLED) { 
			for (Tienda t : tiendas) {
				if (t.getJmsConnectionString() != null && !t.getJmsConnectionString().trim().equalsIgnoreCase("")) {
					jmsManager.enviarOfadATienda(xml, t);
				}
			}
		}
	}

}
