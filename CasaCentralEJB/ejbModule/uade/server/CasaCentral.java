package uade.server;

import java.util.List;

import javax.ejb.Remote;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.SolDistDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.xml.Ofad;
import uade.server.beans.dto.xml.Palc;
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
	public Ofad obtenerOfad() throws CasaCentralException;
	public ArticuloDTO obtenerArticulo(Long ref)throws CasaCentralException;
	public void actualizarOfad(Ofad ofadDto) throws CasaCentralException;
	public ArticuloDTO agregarOfad(Ofad oferta, Long artRef)throws CasaCentralException;
	public ArticuloDTO eliminarArtOfad(Ofad oferta, String idArticulo) throws CasaCentralException;
	
	/**
	 * Palc Functionality Methods
	 */
	public void ingresarPredido(Palc pedido, TiendaDTO tienda) throws CasaCentralException;
	public void nuevaTienda(TiendaDTO t) throws CasaCentralException;;
	
	
	/**
	 * SolDist Functionality Methods
	 */
	public List<CentroDistribucionDTO> obtenerCentrosDeDistribucion() throws CasaCentralException;
	public void nuevoCentroDeDistribucion(CentroDistribucionDTO centro) throws CasaCentralException;
	public List<SolDistDTO> generarSolicitudDistribucion() throws CasaCentralException;
	public SolDistDTO obtenerSolicitudDistribucion(Long idSoldist) throws CasaCentralException;

}
