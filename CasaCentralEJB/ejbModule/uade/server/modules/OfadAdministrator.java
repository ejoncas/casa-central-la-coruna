package uade.server.modules;

import javax.ejb.Local;

import uade.server.beans.Oferta;

@Local
public interface OfadAdministrator {

	Oferta obtenerOfad();

}
