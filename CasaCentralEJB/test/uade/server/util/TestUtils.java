package uade.server.util;

import uade.server.beans.CentroDistribucion;

public class TestUtils {
	
	public CentroDistribucion getCDMock(){
		CentroDistribucion cd = new CentroDistribucion();
		cd.setId(1);
		cd.setLatitud(-37.944198);
		cd.setLongitud(-63.830566);
		return cd;
	}
	
	

}
