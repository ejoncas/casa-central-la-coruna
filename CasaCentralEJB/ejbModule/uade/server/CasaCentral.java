package uade.server;

import javax.ejb.Remote;

import uade.server.bean.dto.ArticuloHogarDTO;
import uade.server.bean.dto.ArticuloRopaDTO;
import uade.server.bean.dto.PedidoDTO;
import uade.server.bean.dto.TiendaDTO;
import uade.server.beans.Pedido;
import uade.server.exception.CasaCentralException;

@Remote
public interface CasaCentral {
	
	/**
	 * Facade
	 * Metodos que se llaman desde la aplicación web
	 */
	
	/**
	 * Nuevo Art Functionality Methods
	 */
	public void nuevoArtRopa(ArticuloRopaDTO art) throws CasaCentralException;
	public void nuevoArtCasa(ArticuloHogarDTO art) throws CasaCentralException;
	
	
	/**
	 * Ofad Functionality Methods
	 */
	
	
	
	/**
	 * Palc Functionality Methods
	 */
	public void ingresarPredido(PedidoDTO pedido, TiendaDTO tienda) throws CasaCentralException;
	
	
	
	/**
	 * SolDist Functionality Methods
	 */

}
