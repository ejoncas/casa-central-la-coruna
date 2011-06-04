package uade.server;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import uade.server.bean.dto.ArticuloHogarDTO;
import uade.server.bean.dto.ArticuloRopaDTO;
import uade.server.bean.dto.PedidoDTO;
import uade.server.bean.dto.TiendaDTO;
import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;
import uade.server.beans.Pedido;
import uade.server.beans.Tienda;
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
	
	
	public void nuevoArtCasa(ArticuloHogarDTO a) throws CasaCentralException {
		logger.info("Creando nuevo articulo de Hogar");
		
		ArticuloHogar ah = new ArticuloHogar(a);
		nuevoArtAdministrator.nuevoArtCasa(ah);
		
		logger.info("Articulo Hogar Creado. REF: #"+ah.getReferencia());
	}

	public void nuevoArtRopa(ArticuloRopaDTO a) throws CasaCentralException {
		logger.info("Creando nuevo articulo de Ropa");
		
		ArticuloRopa ar = new ArticuloRopa(a);
		nuevoArtAdministrator.nuevoArtRopa(ar);
		
		logger.info("Articulo Ropa Creado. REF: #"+ar.getReferencia());
	}

	public void ingresarPredido(PedidoDTO pedido, TiendaDTO tienda)
			throws CasaCentralException {
		logger.info("Ingresando Pedido");
		
		Pedido p = new Pedido(pedido);
		p.setTienda(new Tienda(tienda));
		palcAdministrator.ingresarPedido(p);
		
	}

}
