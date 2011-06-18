package uade.server;

import java.util.List;

import javax.ejb.Remote;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.PedidoDTO;
import uade.server.beans.dto.TiendaDTO;
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
	public ArticuloRopaDTO nuevoArtRopa(ArticuloRopaDTO art) throws CasaCentralException;
	public ArticuloHogarDTO nuevoArtCasa(ArticuloHogarDTO art) throws CasaCentralException;
	public List<ArticuloDTO> obtenerArticulos() throws CasaCentralException;
	public void eliminarArticulo(Long ref) throws CasaCentralException;
	
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
	public List<CentroDistribucionDTO> obtenerCentrosDeDistribucion() throws CasaCentralException;
	public void nuevoCentroDeDistribucion(CentroDistribucionDTO centro) throws CasaCentralException;
	
	

}
