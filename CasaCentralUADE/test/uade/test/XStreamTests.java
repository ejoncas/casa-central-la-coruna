package uade.test;

import junit.framework.TestCase;
import uade.is2.beans.ArticuloHogar;
import uade.is2.beans.ArticuloRopa;
import uade.is2.beans.Envio;
import uade.is2.beans.Pedido;
import uade.is2.beans.xml.NuevoartHogar;
import uade.is2.beans.xml.NuevoartRopa;
import uade.is2.beans.xml.Ofad;
import uade.is2.beans.xml.Palc;
import uade.is2.beans.xml.Soldist;

import com.thoughtworks.xstream.XStream;

public class XStreamTests extends TestCase{
	
	public void testPalc(){
		XStream xs = new XStream();
		
		xs.alias("palc", Palc.class);
		xs.alias("pedido", Pedido.class);
		xs.aliasField("id-tienda", Palc.class, "idTienda");
		
		//test values
		Palc palc = new Palc(1);
		palc.addPedido(1, 2);
		palc.addPedido(3, 14);
		palc.addPedido(132, 20);
		palc.addPedido(200, 4);
		
		//String xml = xs.toXML(palc);
		//System.out.println(xml);
	}
	
	public void testOfad(){
		XStream xs = new XStream();
		
		xs.alias("ofad", Ofad.class);
		xs.alias("articulo", ArticuloRopa.class);
		xs.alias("accesorio", ArticuloHogar.class);
		xs.aliasField("accesorios-hogar", Ofad.class, "accesoriosHogar");
		
		
		Ofad o = new Ofad();
		
		ArticuloHogar h1 = new ArticuloHogar();
		{
			h1.setReferencia(47071029);
			h1.setSeccion("Alfombra");
			h1.setNombre("Alfombra Havana");
			h1.setDescripcion("Alfombra de piel de vaca con patchwork");
			h1.setComposicion("100% Piel Bovina");
			h1.setMedidas("150x200cm");
			h1.setPrecio(new Float(399));
			h1.setColor("Unico");
			h1.setCategoria("Cama");
			h1.setLinea("Unica");
		}
		
		ArticuloRopa r1 = new ArticuloRopa();
		{
			r1.setReferencia(9697001);
			r1.setLinea("Basic");
			r1.setDescripcion("Alfombra de piel de vaca con patcrwork");
			r1.setTalle("L");
			r1.setColor("Blanco");
			r1.setSeccion("Mujer");
			r1.setPrecio(new Float(59));
			r1.setOrigen("Argentina");
		}
		ArticuloHogar h2 = new ArticuloHogar();
		{
			h2.setReferencia(47071029);
			h2.setSeccion("Mueble");
			h2.setNombre("Mueble Local");
			h2.setDescripcion("Mueble re copado");
			h2.setComposicion("100% Madera");
			h2.setMedidas("1502300cm");
			h2.setPrecio(new Float(599));
			h2.setColor("Roble");
			h2.setCategoria("Test");
			h2.setLinea("Unica");
		}
		
		ArticuloRopa r2 = new ArticuloRopa();
		{
			r2.setReferencia(9697001);
			r2.setLinea("Basic");
			r2.setDescripcion("Remera re loca");
			r2.setTalle("M");
			r2.setColor("Negro");
			r2.setSeccion("Hombre");
			r2.setPrecio(new Float(59));
			r2.setOrigen("Chile");
		}
		
		o.addArticuloHogar(h1);
		o.addArticuloHogar(h2);
		o.addArticuloRopa(r1);
		o.addArticuloRopa(r2);

		//String xml = xs.toXML(o);
		//System.out.println(xml);
	}
	
	public void testSoldist(){
		XStream xs = new XStream();
		
		xs.alias("soldist", Soldist.class);
		xs.alias("envio", Envio.class);
		xs.addImplicitCollection(Soldist.class, "envios");
		xs.aliasField("id-tienda", Envio.class, "idTienda");
		
		Soldist sol = new Soldist();
		sol.addEnvio(new Envio(2, 1, "2134rfdsa"));
		sol.addEnvio(new Envio(5, 10, "123rfd"));
		sol.addEnvio(new Envio(12, 40, "123t5yhgfre4"));
		
		//String xml = xs.toXML(sol);
		//System.out.println(xml);
	}
	
	public void testNuevoArt(){
		XStream xs = new XStream();
		
		xs.alias("nuevoart", NuevoartHogar.class);
		xs.alias("nuevoart", NuevoartRopa.class);
		
		
		ArticuloRopa r = new ArticuloRopa();
		{
			r.setReferencia(9697001);
			r.setLinea("Basic");
			r.setDescripcion("Alfombra de piel de vaca con patcrwork");
			r.setTalle("L");
			r.setColor("Blanco");
			r.setSeccion("Mujer");
			r.setPrecio(new Float(59));
			r.setOrigen("Argentina");
		}
		ArticuloHogar h = new ArticuloHogar();
		{
			h.setReferencia(47071029);
			h.setSeccion("Alfombra");
			h.setNombre("Alfombra Havana");
			h.setDescripcion("Alfombra de piel de vaca con patchwork");
			h.setComposicion("100% Piel Bovina");
			h.setMedidas("150x200cm");
			h.setPrecio(new Float(399));
			h.setColor("Unico");
			h.setCategoria("Cama");
			h.setLinea("Unica");
		}
		
		NuevoartHogar artHogar = new NuevoartHogar(h);
		
		NuevoartRopa artRopa = new NuevoartRopa(r);
		
//		System.out.println("**HOGAR**");
//		System.out.println(xs.toXML(artHogar));
//		System.out.println("**ROPA**");
//		System.out.println(xs.toXML(artRopa));
	}
	
	

}
