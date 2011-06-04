package is2.uade.test;


import org.junit.Test;

import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;

public class TestConnectionEAR{
	
	
	@Test
	public void testConnection(){
		try {
			CasaCentralDelegator bussinessDelegator = new CasaCentralDelegator();
			
			bussinessDelegator.nuevoArtCasa(TestUtils.getMockHogar());
			bussinessDelegator.nuevoArtRopa(TestUtils.getMockRopa());
			
		} catch (WebApplicationException e) {
			e.printStackTrace();
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}
	}

}
