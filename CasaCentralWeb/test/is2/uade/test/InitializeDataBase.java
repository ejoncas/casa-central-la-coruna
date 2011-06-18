package is2.uade.test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;

public class InitializeDataBase{
	private CasaCentralDelegator bussinessDelegator; 
	
	@Before
	public void obtenerInstancia() throws WebApplicationException{
		bussinessDelegator = CasaCentralDelegator.getInstance();	
	}
	
	@Test
	public void testConnection(){
		try {
			bussinessDelegator.nuevoArtCasa(TestUtils.getMockHogar());
			bussinessDelegator.nuevoArtRopa(TestUtils.getMockRopa());
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertarCentrosDeDistribucion(){
		List<CentroDistribucionDTO> centros = TestUtils.obtenerCentros();
		try {
			for(CentroDistribucionDTO cd : centros){
					bussinessDelegator.nuevoCentroDeDistribucion(cd);
			}
		} 
		catch (CasaCentralException e) {e.printStackTrace();}
	}
	
	
}
