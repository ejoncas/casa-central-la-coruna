package is2.uade.test;

import java.util.ArrayList;
import java.util.List;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.CentroDistribucionDTO;

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
	
	public static List<CentroDistribucionDTO> obtenerCentros(){
		List<CentroDistribucionDTO> centros = new ArrayList<CentroDistribucionDTO>();
		//TORTUGUITAS
		centros.add(new CentroDistribucionDTO( -34.473165,-58.754025,"TORTUGUITAS"));
		//UNICENTER
		CentroDistribucionDTO unicenter = new CentroDistribucionDTO( -34.50203,-58.52108,"UNICENTER");
		centros.add(unicenter);
		//PUNTA CARRETAS
		centros.add(new CentroDistribucionDTO( -34.927601,-56.160393,"PUNTA CARRETAS"));
		//MONTEVIDEO
		centros.add(new CentroDistribucionDTO( -34.890578,-56.155071,"MONTEVIDEO"));
		//PARQUE ARAUCO
		centros.add(new CentroDistribucionDTO(-33.46775,-70.749872,"PARQUE ARAUCO"));
		//MARINA CENTER
		centros.add(new CentroDistribucionDTO(-33.473836,-70.601921,"MARINA CENTER"));
		
		return centros;
	}
	
}
