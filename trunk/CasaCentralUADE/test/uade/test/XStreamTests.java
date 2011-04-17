package uade.test;

import junit.framework.TestCase;
import uade.is2.beans.Pedido;
import uade.is2.beans.xml.Palc;

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
		
		String xml = xs.toXML(palc);
		
		Palc p = (Palc) xs.fromXML(xml);
		
		System.out.println(xml);
		System.out.println(p);
		
		
	}
	
	public void testOfad(){
		XStream xs = new XStream();
		
		xs.alias("palc", Palc.class);
		xs.alias("pedido", Pedido.class);
		xs.aliasField("id-tienda", Palc.class, "idTienda");
		
	}

}
