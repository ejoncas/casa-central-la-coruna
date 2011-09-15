package uade.server.modules;

import java.util.List;

import javax.ejb.Local;

import uade.server.beans.Articulo;
import uade.server.beans.Oferta;
import uade.server.beans.Tienda;

@Local
public interface OfadAdministrator {

	Oferta obtenerOfad();

	Articulo obtenerArticulo(Long ref);

	void actualizarOferta(Oferta oferta);

	Articulo agregarOfad(Oferta ofer, Articulo art);

	Articulo eliminarArtOfad(Oferta ofer, Articulo art);

	void eliminarOfad(Oferta o);

	List<Tienda> obtenerTiendas();

}
