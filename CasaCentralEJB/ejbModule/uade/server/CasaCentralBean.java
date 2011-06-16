package uade.server;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import uade.server.beans.Articulo;
import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;
import uade.server.beans.Pedido;
import uade.server.beans.Tienda;
import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.exception.CasaCentralException;
import uade.server.modules.NuevoArtAdministrator;
import uade.server.modules.OfadAdministrator;
import uade.server.modules.PalcAdministrator;
import uade.server.modules.SolDistAdministrator;


@Stateless
public class CasaCentralBean implements CasaCentral{

	private static final Logger logger = Logger.getLogger(CasaCentralBean.class);
	
	/**
	 * EJB Modules
	 */
	
	@EJB
	private NuevoArtAdministrator nuevoArtAdministrator;
	@EJB
	private OfadAdministrator ofadAdministrator;
	@EJB
	private PalcAdministrator palcAdministrator;
	@EJB
	private SolDistAdministrator solDistAdministrator;
	
	
	public ArticuloHogarDTO nuevoArtCasa(ArticuloHogarDTO a) throws CasaCentralException {
		logger.info("Creando nuevo articulo de Hogar");
		
		ArticuloHogar ah = new ArticuloHogar(a);
		nuevoArtAdministrator.nuevoArtCasa(ah);
		
		a.setReferencia(ah.getReferencia());
		logger.info("Articulo Hogar Creado. REF: #"+ah.getReferencia());
		return a;
	}

	public ArticuloRopaDTO nuevoArtRopa(ArticuloRopaDTO a) throws CasaCentralException {
		logger.info("Creando nuevo articulo de Ropa");
		
		ArticuloRopa ar = new ArticuloRopa(a);
		nuevoArtAdministrator.nuevoArtRopa(ar);
		
		a.setReferencia(ar.getReferencia());
		logger.info("Articulo Ropa Creado. REF: #"+ar.getReferencia());
		return a;
	}

	public void ingresarPredido(PedidoDTO pedido, TiendaDTO tienda)
			throws CasaCentralException {
		logger.info("Ingresando Pedido");
		
		Pedido p = new Pedido(pedido);
		p.setTienda(new Tienda(tienda));
		
		//Definir el Centro de distribucion
		
		p.setCentroDeDistribucion(null);
		palcAdministrator.ingresarPedido(p);
		
	}

	public List<ArticuloDTO> obtenerArticulos() throws CasaCentralException {
		logger.info("Obteniendo todos los articulos");
		List<Articulo> articulos = nuevoArtAdministrator.obtenerArticulos();
		
		List<ArticuloDTO> resultado = new ArrayList<ArticuloDTO>();
		for(Articulo a : articulos){
			resultado.add(a.getDTO());
		}
		return resultado;
	}

}
