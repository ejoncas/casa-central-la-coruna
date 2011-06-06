package uade.web.xml.util;

import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.EnvioDTO;
import uade.server.beans.dto.PedidoDTO;
import uade.web.xml.NuevoartHogar;
import uade.web.xml.NuevoartRopa;
import uade.web.xml.Ofad;
import uade.web.xml.Palc;
import uade.web.xml.Soldist;

import com.thoughtworks.xstream.XStream;

public class XMLParser {
	
	private XStream xs = null;
	
	private XMLParser(){
		
		/**
		 * Initialization of XStream
		 */
		xs = new XStream();
		
		//PALC Aliases
		xs.alias("palc", Palc.class);
		xs.alias("pedido", PedidoDTO.class);
		xs.aliasField("id-tienda", Palc.class, "idTienda");
		
		//OFAD Aliases
		xs.alias("ofad", Ofad.class);
		xs.alias("articulo", ArticuloRopaDTO.class);
		xs.alias("accesorio", ArticuloHogarDTO.class);
		xs.aliasField("accesorios-hogar", Ofad.class, "accesoriosHogar");
		
		//SOLDIST Aliases
		xs.alias("soldist", Soldist.class);
		xs.alias("envio", EnvioDTO.class);
		xs.addImplicitCollection(Soldist.class, "envios");
		xs.aliasField("id-tienda", EnvioDTO.class, "idTienda");
		
		//NUEVOART Aliases
		xs.alias("nuevoart", NuevoartHogar.class);
		xs.alias("nuevoart", NuevoartRopa.class);
		
	}

}
