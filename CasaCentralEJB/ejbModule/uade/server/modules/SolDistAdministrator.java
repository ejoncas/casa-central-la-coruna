package uade.server.modules;

import java.util.List;

import javax.ejb.Local;

import uade.server.beans.CentroDistribucion;

@Local
public interface SolDistAdministrator {

	List<CentroDistribucion> obtenerCentrosDeDistribucion();

	void nuevoCentroDeDistribucion(CentroDistribucion cd);

}
