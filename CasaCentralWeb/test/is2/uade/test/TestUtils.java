package is2.uade.test;

import java.util.ArrayList;
import java.util.List;

import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.CentroDistribucionDTO;
import uade.server.beans.dto.TiendaDTO;

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
		centros.add(new CentroDistribucionDTO( 34.549549,58.573952,"TORTUGUITAS"));
		//UNICENTER
		CentroDistribucionDTO unicenter = new CentroDistribucionDTO( 34.50203,58.52108,"UNICENTER");
		centros.add(unicenter);
		//PUNTA CARRETAS
		centros.add(new CentroDistribucionDTO( 34.927601,56.160393,"PUNTA CARRETAS"));
		//MONTEVIDEO
		centros.add(new CentroDistribucionDTO( 34.890578,56.155071,"MONTEVIDEO"));
		//PARQUE ARAUCO
		centros.add(new CentroDistribucionDTO(33.46775,70.749872,"PARQUE ARAUCO"));
		//MARINA CENTER
		centros.add(new CentroDistribucionDTO(33.473836,70.601921,"MARINA CENTER"));
		
		return centros;
	}

	public static List<TiendaDTO> obtenerTiendas() {
		List<TiendaDTO> tiendas = new ArrayList<TiendaDTO>();
		//ARGENTINA
		tiendas.add(new TiendaDTO("Tortuguitas",34.50981 ,58.573980));
		tiendas.add(new TiendaDTO("Unicenter",34.433036,58.520935));
		tiendas.add(new TiendaDTO("Santa Fé",34.551811,58.417225));
		tiendas.add(new TiendaDTO("Abasto",34.611807,58.417311));
		tiendas.add(new TiendaDTO("Florida",34.61163,58.38418));
		tiendas.add(new TiendaDTO("Paseo Alcorta",34.575154,58.404243));
		
		//URUGUAY
		tiendas.add(new TiendaDTO("Punta Carretas",34.919086,56.163054));
		tiendas.add(new TiendaDTO("Montevideo Shopping",34.88931,56.058576));
		
		//CHILE
		tiendas.add(new TiendaDTO("Parque Arauco", 33.465924, 70.655909));
		tiendas.add(new TiendaDTO("Marina Center",33.389026,70.714874));
		
		tiendas.add(new TiendaDTO("Alto Las Condes",33.46912,70.641997));
		tiendas.add(new TiendaDTO("Florida Center",33.467535,70.689468));
		tiendas.add(new TiendaDTO("La Dehesa",33.401638, 70.583382));
		return tiendas;
	}
	
}
