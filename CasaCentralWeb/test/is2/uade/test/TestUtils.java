package is2.uade.test;

import java.util.ArrayList;
import java.util.Date;
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
		m.setMesRebaja(new Date());
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
		m.setMesRebaja(new Date());
		return m;
	}
	
	public static List<CentroDistribucionDTO> obtenerCentros(){
		List<CentroDistribucionDTO> centros = new ArrayList<CentroDistribucionDTO>();
		//TORTUGUITAS
		centros.add(new CentroDistribucionDTO(11L, 34.549549,58.573952,"TORTUGUITAS (GRUPO 11)"));
		//UNICENTER
		CentroDistribucionDTO unicenter = new CentroDistribucionDTO(6L,34.50203,58.52108,"UNICENTER (GRUPO 6)");
		centros.add(unicenter);
		//PUNTA CARRETAS
		centros.add(new CentroDistribucionDTO(5L,34.927601,56.160393,"PUNTA CARRETAS (GRUPO 5)"));
		//MONTEVIDEO
		centros.add(new CentroDistribucionDTO(10L,34.890578,56.155071,"MONTEVIDEO (GRUPO 10)"));
		//PARQUE ARAUCO
		//centros.add(new CentroDistribucionDTO(33.46775,70.749872,"PARQUE ARAUCO"));
		//MARINA CENTER
		//centros.add(new CentroDistribucionDTO(33.473836,70.601921,"MARINA CENTER"));
		
		return centros;
	}

	public static List<TiendaDTO> obtenerTiendas() {
		List<TiendaDTO> tiendas = new ArrayList<TiendaDTO>();
		//ARGENTINA
		tiendas.add(new TiendaDTO(4L,"Tortuguitas (GRUPO 4)",34.50981 ,58.573980));
		tiendas.add(new TiendaDTO(8L,"Unicenter (GRUPO 8)",34.433036,58.520935));
	/*	tiendas.add(new TiendaDTO("Santa Fé",34.551811,58.417225));
		tiendas.add(new TiendaDTO("Abasto",34.611807,58.417311));
		tiendas.add(new TiendaDTO("Florida",34.61163,58.38418));
		tiendas.add(new TiendaDTO("Paseo Alcorta",34.575154,58.404243));*/
		
		//URUGUAY
		tiendas.add(new TiendaDTO(3L,"Punta Carretas (GRUPO 3)",34.919086,56.163054));
		//tiendas.add(new TiendaDTO("Montevideo Shopping",34.88931,56.058576));
		
		//CHILE
		tiendas.add(new TiendaDTO(9L,"Parque Arauco (GRUPO 9)", 33.465924, 70.655909));
		//tiendas.add(new TiendaDTO("Marina Center",33.389026,70.714874));
		
		/*tiendas.add(new TiendaDTO("Alto Las Condes",33.46912,70.641997));
		tiendas.add(new TiendaDTO("Florida Center",33.467535,70.689468));
		tiendas.add(new TiendaDTO("La Dehesa",33.401638, 70.583382));*/
		return tiendas;
	}
	
	
	public static List<ArticuloRopaDTO> getMockRopaListOriginal(){
		List<ArticuloRopaDTO> articulos = new ArrayList<ArticuloRopaDTO>();
		
		ArticuloRopaDTO m = new ArticuloRopaDTO();
		{
			m.setColor("Blanco");
			m.setDescripcion("Camiseta Algodon");
			m.setLinea("Basic");
			m.setPrecio(new Float(59.00));
			m.setSeccion("Mujer");
			m.setOrigen("Argentina");
			m.setSeccion("Pantalones");
			m.setTalle("L");
			m.setMesRebaja(new Date());
		}
		articulos.add(m);
		
		ArticuloRopaDTO m2 = new ArticuloRopaDTO();
		{
			m2.setColor("Negro");
			m2.setDescripcion("Vestido Corto C/Atado");
			m2.setLinea("Basic");
			m2.setPrecio(new Float(119.00));
			m2.setSeccion("Mujer");
			m2.setOrigen("Asia");
			m2.setSeccion("Pantalones");
			m2.setTalle("L");
			m2.setMesRebaja(new Date());
		}
		articulos.add(m2);
		
		return articulos;
	}

	public static List<ArticuloHogarDTO> getMockHogarListOriginal() {
		List<ArticuloHogarDTO> articulos = new ArrayList<ArticuloHogarDTO>();
		
		/**
		 * 47071029					.	$ 399.00			
		 * 43239029					.				
		 */
		
		ArticuloHogarDTO  m2 = new ArticuloHogarDTO();
		{
			m2.setCategoria("Cama");
			m2.setColor("Unico");
			m2.setComposicion("100% Piel Bovina");
			m2.setDescripcion("Alfombra de piel de vaca con estampado de cebra");
			m2.setLinea("Unica");
			m2.setMedidas("150x200cm");
			m2.setNombre("Alfombra Cebra");
			m2.setPrecio(new Float(349));
			m2.setMesRebaja(new Date());
			//m.setReferencia();
			m2.setSeccion("Alfombra");
		}
		articulos.add(m2);
		ArticuloHogarDTO m = new ArticuloHogarDTO();
		{
			m.setCategoria("Cama");
			m.setColor("Unico");
			m.setComposicion("100% Piel Bovina");
			m.setDescripcion("Alfombra de piel de vaca con patchwork");
			m.setLinea("Unica");
			m.setMedidas("150x200cm");
			m.setNombre("Alfrombra Habana");
			m.setPrecio(new Float(399.00));
			//m.setReferencia();
			m.setSeccion("Alfombra");
			m.setMesRebaja(new Date());
		}
		articulos.add(m);
		

		
		return articulos;
	}
	
}
