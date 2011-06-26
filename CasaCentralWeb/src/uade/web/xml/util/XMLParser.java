package uade.web.xml.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.EnvioDTO;
import uade.server.beans.dto.ItemPedidoDTO;
import uade.server.beans.dto.ItemPedidoXmlDTO;
import uade.server.beans.dto.xml.NuevoartHogar;
import uade.server.beans.dto.xml.NuevoartRopa;
import uade.server.beans.dto.xml.Ofad;
import uade.server.beans.dto.xml.Palc;
import uade.server.beans.dto.xml.Soldist;

import com.thoughtworks.xstream.XStream;

public class XMLParser {
	
	private static XStream xs = null;
	private static PropertiesConfiguration config;
	
	static{
		try {
			config = new PropertiesConfiguration("config.properties");
		} 
		catch (ConfigurationException e) {e.printStackTrace();}
	}
	
	private XMLParser(){
		
		/**
		 * Initialization of XStream
		 */
		xs = new XStream();
		
		//PALC Aliases
		xs.alias("palc", Palc.class);
		xs.alias("pedido", ItemPedidoXmlDTO.class);
		xs.aliasField("ref", Palc.class, "idTienda");
		
		
		//OFAD Aliases
		xs.alias("ofad", Ofad.class);
		xs.alias("articulo", ArticuloRopaDTO.class);
		xs.alias("accesorio", ArticuloHogarDTO.class);
		xs.aliasField("accesorios-hogar", Ofad.class, "accesoriosHogar");
		
		//SOLDIST Aliases
		xs.alias("soldist", Soldist.class);
		xs.alias("envio", EnvioDTO.class);
		xs.addImplicitCollection(Soldist.class, "envios");
		
		//NUEVOART Aliases
		xs.alias("nuevoart", NuevoartHogar.class);
		xs.alias("nuevoart", NuevoartRopa.class);
		xs.aliasField("ref", ArticuloDTO.class, "referencia");
		
		
		//Ignores
		xs.omitField(ArticuloDTO.class, "centros");
		
		
	}
	
	public static synchronized String parse(Object o){
		if(xs == null)
			new XMLParser();
		return xs.toXML(o);
	}
	
	public static synchronized Object parseObject(File f) throws FileNotFoundException{
		if(xs==null)
			new XMLParser();
		return xs.fromXML(new FileInputStream(f));
	}
	
	public static synchronized Object parseObject(String f){
		if(xs==null)
			new XMLParser();
		return xs.fromXML(f);
	}
	
	public static synchronized void parseAndSave(Object o , File f) throws FileNotFoundException{
		if(xs==null)
			new XMLParser();
		xs.toXML(o,new FileOutputStream(f));
	}

	public static void generateXmlAndSave(Object xmlObject) throws FileNotFoundException {
		String dirFile = config.getString("xml.dir");
		dirFile += xmlObject.getClass().getSimpleName()+"-"+new SimpleDateFormat("yyyyMMdd-hhss").format(new Date());
		parseAndSave(xmlObject, new File(dirFile));
	}

}
