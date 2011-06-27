package uade.web.bussiness;

import java.util.Hashtable;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import uade.server.CasaCentral;
import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.SolDistDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.xml.Ofad;
import uade.server.beans.dto.xml.Palc;
import uade.server.exception.CasaCentralException;
import uade.web.exception.WebApplicationException;

public class CasaCentralDelegator implements CasaCentral{

	private CasaCentral casaCentral;
	
	private static CasaCentralDelegator instance; 
	
	
	/**
	 * Constructor work as service locator. It tries to obtain the instance
	 * of the Bean in the EJB deployed proyect.
	 * 
	 * @property namin.url - Located at config.properties webapp file
	 * @throws WebApplicationException
	 */
	private CasaCentralDelegator() throws WebApplicationException{
		try {
			PropertiesConfiguration config = new PropertiesConfiguration("config.properties");
			Hashtable<String, String> props = new Hashtable<String,String>();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(InitialContext.PROVIDER_URL,config.getString("naming.url"));
			InitialContext ic;
			ic = new InitialContext(props);
			casaCentral = (CasaCentral)ic.lookup(config.getString("naming.lookup"));
		} catch (NamingException e) {
			throw new WebApplicationException(e,"Error al obtener la instancia del CasaCentralBean");
		} catch (ConfigurationException e) {
			throw new WebApplicationException(e,"Error al obtener el archivo con las configuraciones web");
		}
	}
	
	//Eager singleton
	public static synchronized CasaCentralDelegator getInstance() throws WebApplicationException{
		if(instance==null){
			 instance = new CasaCentralDelegator();
		}
		return instance;
	}
	
	
	/**
	 * Proxy for bussiness implementations
	 */
	public ArticuloHogarDTO nuevoArtCasa(ArticuloHogarDTO a) throws CasaCentralException {
		return casaCentral.nuevoArtCasa(a);
	}

	public ArticuloRopaDTO nuevoArtRopa(ArticuloRopaDTO a) throws CasaCentralException {
		return casaCentral.nuevoArtRopa(a);
	}


	public void ingresarPredido(Palc pedido, TiendaDTO tienda)
			throws CasaCentralException {
		casaCentral.ingresarPredido(pedido, tienda);
	}

	public List<ArticuloDTO> obtenerArticulos() throws CasaCentralException {
		return casaCentral.obtenerArticulos();
	}

	public void eliminarArticulo(Long ref) throws CasaCentralException {
		casaCentral.eliminarArticulo(ref);
	}

	public List<CentroDistribucionDTO> obtenerCentrosDeDistribucion() throws CasaCentralException {
		return casaCentral.obtenerCentrosDeDistribucion();
	}

	public void nuevoCentroDeDistribucion(CentroDistribucionDTO centro)
			throws CasaCentralException {
		casaCentral.nuevoCentroDeDistribucion(centro);
	}

	public void nuevaTienda(TiendaDTO t) throws CasaCentralException {
		casaCentral.nuevaTienda(t);
	}

	public List<SolDistDTO> generarSolicitudDistribucion() throws CasaCentralException{
		return casaCentral.generarSolicitudDistribucion();
	}

	public SolDistDTO obtenerSolicitudDistribucion(Long idSoldist) throws CasaCentralException {
		return casaCentral.obtenerSolicitudDistribucion(idSoldist);
	}

	public Ofad obtenerOfad() throws CasaCentralException{
		return casaCentral.obtenerOfad();
	}

}
