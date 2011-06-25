package uade.server.beans.logic;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;

public class CentroDeDistribucionLocator {


	public CentroDeDistribucionLocator() {
	}
	
	public CentroDistribucion obtenerCentroMasCercano(Tienda t, List<CentroDistribucion> centros) {
		Map<Double, CentroDistribucion> mapa = new TreeMap<Double, CentroDistribucion>();
		Double minDistance = Double.MAX_VALUE;
		for (CentroDistribucion cd : centros) {
			Double distance = Math.sqrt(Math.pow(cd.getLatitud() - t.getLatitud(),2)+ Math.pow(cd.getLongitud()- t.getLongitud(),2));
			mapa.put(distance , cd);
			if(distance<minDistance)
				minDistance = distance;
		}
		return mapa.get(minDistance);
	}
}
