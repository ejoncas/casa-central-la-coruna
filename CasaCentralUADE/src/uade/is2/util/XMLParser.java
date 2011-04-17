package uade.is2.util;

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

public class XMLParser {
	
	private XStream xs = null;
	
	private XMLParser(){
		xs = new XStream();
		
		//PALC Aliases
		xs.alias("palc", Palc.class);
		xs.alias("pedido", Pedido.class);
		xs.aliasField("id-tienda", Palc.class, "idTienda");
		
		//OFAD Aliases
		xs.alias("ofad", Ofad.class);
		xs.alias("articulo", ArticuloRopa.class);
		xs.alias("accesorio", ArticuloHogar.class);
		xs.aliasField("accesorios-hogar", Ofad.class, "accesoriosHogar");
		
		//SOLDIST Aliases
		xs.alias("soldist", Soldist.class);
		xs.alias("envio", Envio.class);
		xs.addImplicitCollection(Soldist.class, "envios");
		xs.aliasField("id-tienda", Envio.class, "idTienda");
		
		//NUEVOART Aliases
		xs.alias("nuevoart", NuevoartHogar.class);
		xs.alias("nuevoart", NuevoartRopa.class);
		
	}

}
