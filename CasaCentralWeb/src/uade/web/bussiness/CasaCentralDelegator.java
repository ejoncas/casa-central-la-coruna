package uade.web.bussiness;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import uade.server.CasaCentral;
import uade.server.bean.dto.ArticuloHogarDTO;
import uade.server.bean.dto.ArticuloRopaDTO;
import uade.server.bean.dto.PedidoDTO;
import uade.server.bean.dto.TiendaDTO;
import uade.server.exception.CasaCentralException;
import uade.web.exception.WebApplicationException;

public class CasaCentralDelegator implements CasaCentral{

	private CasaCentral casaCentral;
	
	
	/**
	 * Constructor work as service locator. It tries to obtain the instance
	 * of the Bean in the EJB deployed proyect.
	 * 
	 * @property namin.url - Located at config.properties webapp file
	 * @throws WebApplicationException
	 */
	public CasaCentralDelegator() throws WebApplicationException{
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
	
	
	/**
	 * Proxy for bussiness implementations
	 */
	public void nuevoArtCasa(ArticuloHogarDTO a) throws CasaCentralException {
		casaCentral.nuevoArtCasa(a);
	}

	public void nuevoArtRopa(ArticuloRopaDTO a) throws CasaCentralException {
		casaCentral.nuevoArtRopa(a);
	}


	public void ingresarPredido(PedidoDTO pedido, TiendaDTO tienda)
			throws CasaCentralException {
		casaCentral.ingresarPredido(pedido, tienda);
	}

}
