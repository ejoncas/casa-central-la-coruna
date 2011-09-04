package uade.server.service.xml.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloHogarOfadDTO;
import uade.server.beans.dto.ArticuloOfadDTO;
import uade.server.beans.dto.ArticuloRopaDTO;
import uade.server.beans.dto.ArticuloRopaOfadDTO;
import uade.server.beans.dto.EnvioDTO;
import uade.server.beans.dto.xml.ItemPedidoXml2DTO;
import uade.server.beans.dto.xml.ItemPedidoXmlDTO;
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
		new XMLParser();
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
		xs.aliasField("accesorios-hogar", Ofad.class, "accesoriosHogar");
		
		//SOLDIST Aliases
		xs.alias("solDist", Soldist.class);
		xs.alias("envio", EnvioDTO.class);
		xs.alias("articulos", ItemPedidoXml2DTO.class);
		xs.addImplicitCollection(Soldist.class, "envios");
		xs.addImplicitCollection(EnvioDTO.class, "pedidos");
		
		
		
		//NUEVOART Aliases
		xs.alias("nuevoArt", NuevoartHogar.class);
		xs.alias("nuevoArt", NuevoartRopa.class);
		
		

		xs.omitField(ArticuloDTO.class, "mesRebaja");
		xs.omitField(ArticuloDTO.class, "centros");
		xs.omitField(ArticuloDTO.class, "type");
		xs.omitField(ArticuloDTO.class, "descuento");
		xs.aliasField("ref", ArticuloDTO.class, "referencia");
		
		xs.omitField(ArticuloOfadDTO.class, "centros");
		xs.omitField(ArticuloOfadDTO.class, "type");
		xs.omitField(ArticuloOfadDTO.class, "mesRebaja");
		xs.aliasField("ref", ArticuloOfadDTO.class, "referencia");
		
		xs.alias("articulo", ArticuloRopaDTO.class);
		xs.alias("accesorio", ArticuloHogarDTO.class);
		xs.alias("articulo", ArticuloRopaOfadDTO.class);
		xs.alias("accesorio", ArticuloHogarOfadDTO.class);
		
		xs.omitField(Ofad.class, "id");
		xs.omitField(Palc.class, "centroDistribucion");
		
		
	}
	
	public static synchronized String parse(Object o){
		generateXmlAndSave(o);
		return xs.toXML(o);
	}
	
	public static synchronized Object parseObject(File f) throws FileNotFoundException{
		return xs.fromXML(new FileInputStream(f));
	}
	
	public static synchronized Object parseObject(String f){
		return xs.fromXML(f);
	}
	
	public static synchronized void parseAndSave(Object o , File f) throws IOException{
		FileOutputStream outputStream = new FileOutputStream(f);
		Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		xs.toXML(o,writer);	
	}

	public static void generateXmlAndSave(Object xmlObject){
		String dirFile = config.getString("xml.dir");
		dirFile += xmlObject.getClass().getSimpleName()+"-"+new SimpleDateFormat("yyyyMMdd-hhss").format(new Date())+".xml";
		try {
			parseAndSave(xmlObject, new File(dirFile));
		}
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}

}
