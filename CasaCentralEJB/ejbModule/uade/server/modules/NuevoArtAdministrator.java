package uade.server.modules;

import java.util.List;

import javax.ejb.Local;

import uade.server.beans.Articulo;
import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;
import uade.server.beans.CentroDistribucion;

@Local
public interface NuevoArtAdministrator {

	void nuevoArtCasa(ArticuloHogar ah);

	void nuevoArtRopa(ArticuloRopa ar);

	List<Articulo> obtenerArticulos();

	void eliminarArticulo(Long ref);

	Articulo getArticuloById(Long ref);
	
	CentroDistribucion obtenerCentroDistribucion(Long ref);

}
