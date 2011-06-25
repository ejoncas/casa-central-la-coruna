package is2.uade.test;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import uade.server.beans.dto.xml.Palc;
import uade.web.xml.util.XMLParser;

public class XMLParserTest {

	@Test
	public void testPalc() throws FileNotFoundException{
		Palc palc = (Palc) XMLParser.parseObject(new File("C:/Users/jonatan/Desktop/Ejemplos XML/palc-example.xml"));

		//Assert rules
		Assert.assertNotNull(palc);
		Assert.assertNotNull(palc.getPedidos());
		Assert.assertEquals(palc.getPedidos().size(),3);
	}
	
	public void testSoldist(){
		
	}
	
	public void testNuevoArt(){
		
	}
	
	public void testOfad(){
		
	}
	
}
