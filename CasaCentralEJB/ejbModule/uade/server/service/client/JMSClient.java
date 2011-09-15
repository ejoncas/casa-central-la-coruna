package uade.server.service.client;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.Tienda;

public class JMSClient {

	private final static Logger logger = LoggerFactory.getLogger(JMSClient.class);
	private PropertiesConfiguration config;

	private QueueConnection conn;
	private QueueSession session;
	private Queue que;

	private boolean initialized = false;
	
	/** SINGLETON **/
	private static JMSClient instance;
	
	private JMSClient() {
		try {
			config = new PropertiesConfiguration("config.properties");
		} catch (ConfigurationException e) {e.printStackTrace();}
	}
	
	public static JMSClient getInstance() {
		if (instance == null)
			instance = new JMSClient();
		return instance;
	}

	public void sendMessageToFabrica(String text) throws JMSException, NamingException {
		logger.info("Enviando mensaje a la fabrica");
		// Setup the PTP connection, session
		setupJmsFabrica();
		// Send a text msg
		QueueSender send = session.createSender(que);
		TextMessage tm = session.createTextMessage(text);
		send.send(tm);
		logger.info("sendRecvAsync, sent text=" + tm.getText());
		send.close();
		logger.info("Mensaje enviado a la fabrica satisfactoriamente.");
	}
	
	//paso el objeto tienda proque no se si se tiene que hacer algo con sus datos, de ultima si no se usa nada se pasa un string y a la bosta
	public void enviarOfad(String text, Tienda tienda) throws JMSException, NamingException{
		logger.info("Comenzando el envio a la tienda con la IP nro: "+tienda.getIp()+" nombre: "+tienda.getNombre());

		setupJmsTienda(tienda.getQueueName(), tienda.getIp());
		QueueSender send = session.createSender(que);
		TextMessage tm = session.createTextMessage(text);
		send.send(tm);
		logger.info("enviarOfad, texto enviado=" + tm.getText());
		send.close();
		logger.info("Mensaje enviado a la tienda satisfactoriamente. Mensaje [ " + text +  "]. Tienda [" + tienda.getNombre() + "]");
	}

	public void enviarSolDist(String text, CentroDistribucion cd) throws JMSException, NamingException{
		logger.info("Comenzando el envio al centro de distribucion con IP nro: "+cd.getIp()+" y nombre: "+cd.getNombre());
		
		setupJmsCentroDistribucion(cd.getQueueName(), cd.getIp());
		QueueSender send = session.createSender(que);
		TextMessage tm = session.createTextMessage(text);
		send.send(tm);
		logger.info("enviarSolDist, texto enviado=" + tm.getText());
		send.close();
		logger.info("enviarSolDist End");
		logger.info("Mensaje enviado a los centros de distribucion satisfactoriamente. Centro de Distribucion [" + cd.getNombre() + "]");
	}
	
	
	public void stop() throws JMSException {
		conn.stop();
		session.close();
		conn.close();
		initialized = false;
	}
	

	public void setupJmsFabrica() throws JMSException, NamingException {
		if (!initialized) {
			Context ctx = new InitialContext(generateJmsProperties(config.getString("jms.connectionstring")));
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup(config.getString("jms.lookup"));

			conn = qfactory.createQueueConnection();
			que = (Queue) ctx.lookup(config.getString("jms.queue.lookup"));
			session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);

			conn.start();
			initialized = true;
		}
	}
	
	public void setupJmsTienda(String queueName, String lookup) throws JMSException, NamingException {
		Context ctx = new InitialContext(generateJmsProperties(lookup));
		//FIXME cambiar el attr de tienda de IP por lookup y agregar el puerto y el path ahi
		QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup("jnp://" + lookup + ":1099");

		conn = qfactory.createQueueConnection();
		que = (Queue) ctx.lookup(queueName);
		session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);

		conn.start();
	}

	private void setupJmsCentroDistribucion(String queueName, String lookup) throws JMSException, NamingException {
		setupJmsTienda(queueName, lookup);
	}

	private Hashtable<String, String> generateJmsProperties(String lookup) {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		props.put(InitialContext.PROVIDER_URL, lookup);
		return props;
	}
	

}