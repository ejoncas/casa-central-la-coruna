package uade.server.modules;

import javax.ejb.Local;

import uade.server.beans.Articulo;
import uade.server.beans.Oferta;

@Local
public interface OfadAdministrator {

	Oferta obtenerOfad();

	Articulo obtenerArticulo(Long ref);

	void actualizarOferta(Oferta oferta);

	Articulo agregarOfad(Oferta ofer, Articulo art);

	Articulo eliminarArtOfad(Oferta ofer, Articulo art);

}
