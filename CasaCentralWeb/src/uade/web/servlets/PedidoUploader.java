package uade.web.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import uade.web.xml.Palc;
import uade.web.xml.util.XMLParser;

/**
 * Servlet implementation class for Servlet: Pedido
 * 
 */
public class PedidoUploader extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private File tmpDir;
	private File destinationDir;
	
	private PropertiesConfiguration configuration = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			configuration = new PropertiesConfiguration("config.properties");
			
			
			String tmpDirPath = configuration.getString("xml.palc.dir");
			String destDirPath =configuration.getString("xml.palc.dir");
			
			tmpDir = new File(tmpDirPath);
			if (!tmpDir.isDirectory()) {
				throw new ServletException(tmpDirPath + " is not a directory");
			}
			destinationDir = new File(destDirPath);
			if (!destinationDir.isDirectory()) {
				throw new ServletException(destDirPath
						+ " is not a directory");
			}
		} 
		catch (ConfigurationException e) {e.printStackTrace();}
	}

	public PedidoUploader() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException {
		File f = parseAndSaveUploadedFile(request);
		
		Palc pedido = (Palc) XMLParser.parseObject(f);
		
		
		
		System.out.println(f.toString());
	}

	private File parseAndSaveUploadedFile(HttpServletRequest request) throws FileNotFoundException {
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setSizeThreshold(1 * 1024 * 1024); // 1 MB
		fileItemFactory.setRepository(tmpDir);
		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

		/*
		 * Parse the request
		 */
		List items;
		try {
			items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();
			if (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (!item.isFormField()) {
					File file = new File(destinationDir, item.getName());
					item.write(file);
					return file;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new FileNotFoundException("No se pudo crear el archivo");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}