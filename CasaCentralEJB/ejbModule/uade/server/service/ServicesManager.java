package uade.server.service;

import java.util.List;

import javax.ejb.Local;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.SolDistDTO;

@Local
public interface ServicesManager {
	
	void enviarNuevoArtHogarJMS(ArticuloHogarDTO a, List<CentroDistribucion> centros);
	void enviarNuevoArtRopaJMS(ArticuloRopaDTO a, List<CentroDistribucion> centros);
	void enviarSolicitudesDistribucionWS(List<SolDistDTO> r);
	void enviarOfadJMS(String xml, List<Tienda> tiendas);

}
