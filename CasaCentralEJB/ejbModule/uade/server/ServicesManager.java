package uade.server;

import java.util.List;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.SolDistDTO;

public interface ServicesManager {
	
	public void enviarNuevoArtHogarJMS(ArticuloHogarDTO a, List<CentroDistribucion> centros);
	public void enviarNuevoArtRopaJMS(ArticuloRopaDTO a, List<CentroDistribucion> centros);
	public void enviarSolicitudesDistribucionWS(List<SolDistDTO> r);
	public void enviarOfadJMS(String xml, List<Tienda> tiendas);

}
