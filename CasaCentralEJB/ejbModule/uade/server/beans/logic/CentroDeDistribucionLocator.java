package uade.server.beans.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;

public class CentroDeDistribucionLocator {

	private List<CentroDistribucion> centrosDeDistribucion;

	public CentroDeDistribucionLocator() {
		this.centrosDeDistribucion = new ArrayList<CentroDistribucion>();
	}
	
	public CentroDistribucion obtenerCentroMasCercano(Tienda t, List<CentroDistribucion> centros) {
		Map<Double, CentroDistribucion> mapa = new TreeMap<Double, CentroDistribucion>();
		for (CentroDistribucion cd : this.centrosDeDistribucion) {
			mapa.put(
					Math.sqrt(Math.pow(cd.getLatitud() - t.getLatitud(),2)+ Math.pow(cd.getLongitud()- t.getLongitud(),2)),
					cd
					);
		}
		return mapa.get(mapa.keySet().iterator().next());
	}
}
