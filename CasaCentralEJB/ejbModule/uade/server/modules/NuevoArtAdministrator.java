package uade.server.modules;

import java.util.List;

import javax.ejb.Local;

import uade.server.beans.Articulo;
import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;

@Local
public interface NuevoArtAdministrator {

	void nuevoArtCasa(ArticuloHogar ah);

	void nuevoArtRopa(ArticuloRopa ar);

	List<Articulo> obtenerArticulos();

	void eliminarArticulo(Long ref);

}
