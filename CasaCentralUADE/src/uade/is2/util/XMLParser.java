package uade.is2.util;

import uade.is2.beans.Pedido;
import uade.is2.beans.xml.Palc;

import com.thoughtworks.xstream.XStream;

public class XMLParser {
	
	private XStream xs = null;
	
	private XMLParser(){
		xs = new XStream();
		
		//PALC Aliases
		xs.alias("palc", Palc.class);
		xs.alias("pedido", Pedido.class);
		xs.aliasField("id-tienda", Palc.class, "idTienda");
		
	}

}
