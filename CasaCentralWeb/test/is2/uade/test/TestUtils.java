package is2.uade.test;

import uade.server.bean.dto.ArticuloHogarDTO;
import uade.server.bean.dto.ArticuloRopaDTO;

public class TestUtils {

	
	public static ArticuloHogarDTO getMockHogar(){
		ArticuloHogarDTO m = new ArticuloHogarDTO();
		m.setCategoria("Mesas");
		m.setColor("Roble");
		m.setComposicion("Madera de Roble");
		m.setDescripcion("Mesa Ratona para la familia");
		m.setLinea("Bussiness");
		m.setMedidas("12x12x12");
		m.setNombre("Mesa Robinson Raton");
		m.setPrecio(new Float(12));
		//m.setReferencia();
		m.setSeccion("Casa");
		return m;
	}
	
	public static ArticuloRopaDTO getMockRopa(){
		ArticuloRopaDTO m = new ArticuloRopaDTO();
		m.setColor("Marron");
		m.setDescripcion("Pantalones Baqueros con flecos");
		m.setLinea("Wild West");
		m.setPrecio(new Float(12));
		//m.setReferencia();
		m.setSeccion("Ropa");
		m.setOrigen("Francia");
		m.setSeccion("Pantalones");
		m.setTalle("L");
		return m;
	}
	
}
