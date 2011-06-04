package uade.server.modules;

import javax.ejb.Local;

import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;

@Local
public interface NuevoArtAdministrator {

	void nuevoArtCasa(ArticuloHogar ah);

	void nuevoArtRopa(ArticuloRopa ar);

}
