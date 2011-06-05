package uade.server.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;
import uade.server.beans.logic.CentroDeDistribucionLocator;

public class TestDistanceSort {
	
	@Test
	public void testname() throws Exception {
		
		List<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		
		
		//TORTUGUITAS
		centros.add(new CentroDistribucion( -34.473165,-58.754025,"TORTUGUITAS"));
		//UNICENTER
		CentroDistribucion unicenter = new CentroDistribucion( -34.50203,-58.52108,"UNICENTER");
		centros.add(unicenter);
		//PUNTA CARRETAS
		centros.add(new CentroDistribucion( -34.927601,-56.160393,"PUNTA CARRETAS"));
		//MONTEVIDEO
		centros.add(new CentroDistribucion( -34.890578,-56.155071,"MONTEVIDEO"));
		//PARQUE ARAUCO
		centros.add(new CentroDistribucion(-33.46775,-70.749872,"PARQUE ARAUCO"));
		//MARINA CENTER
		centros.add(new CentroDistribucion(-33.473836,-70.601921,"MARINA CENTER"));
		
		CentroDeDistribucionLocator cl =  new CentroDeDistribucionLocator(centros);
		
		Tienda t  = new Tienda();
		t.setLatitud(unicenter.getLatitud()-0.000100);
		t.setLongitud(unicenter.getLongitud()-0.000100);
		
		CentroDistribucion cd  = cl.obtenerCentroMasCercano(t);
		System.out.println(cd.getNombre());
		Assert.assertEquals(cd, unicenter);
	}

}
