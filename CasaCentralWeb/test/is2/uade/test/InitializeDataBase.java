package is2.uade.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.TiendaDTO;
import uade.server.exception.CasaCentralException;
import uade.web.bussiness.CasaCentralDelegator;
import uade.web.exception.WebApplicationException;

public class InitializeDataBase {
	private CasaCentralDelegator bussinessDelegator;

	@Before
	public void obtenerInstancia() throws WebApplicationException {
		bussinessDelegator = CasaCentralDelegator.getInstance();
	}

	@Test
	public void testConnection() {
		try {
			/*bussinessDelegator.nuevoArtCasa(TestUtils.getMockHogar());
			bussinessDelegator.nuevoArtRopa(TestUtils.getMockRopa());*/
			
			for(ArticuloRopaDTO art : TestUtils.getMockRopaListOriginal()){
				bussinessDelegator.nuevoArtRopa(art);
			}
			
			for(ArticuloHogarDTO art : TestUtils.getMockHogarListOriginal()){
				bussinessDelegator.nuevoArtCasa(art);
			}
			
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertarCentrosDeDistribucion() {
		List<CentroDistribucionDTO> centros = TestUtils.obtenerCentros();
		try {
			for (CentroDistribucionDTO cd : centros) {
				bussinessDelegator.nuevoCentroDeDistribucion(cd);
			}
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertarTiendas() {
		List<TiendaDTO> tiendas = TestUtils.obtenerTiendas();
		try {
			for (TiendaDTO t : tiendas) {
				bussinessDelegator.nuevaTienda(t);
			}
		} catch (CasaCentralException e) {
			e.printStackTrace();
		}

	}

}
