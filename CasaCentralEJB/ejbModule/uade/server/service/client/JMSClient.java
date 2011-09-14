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

	QueueConnection conn;
	QueueSession session;
	Queue que;

	private boolean initialized = false;
	
	public JMSClient() {
		try {
			config = new PropertiesConfiguration("config.properties");
		} catch (ConfigurationException e) {e.printStackTrace();}
	}
	

	public void setupPTP() throws JMSException, NamingException {
		if (!initialized) {
			Hashtable<String, String> props = new Hashtable<String, String>();

			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");

			props.put(InitialContext.PROVIDER_URL, config.getString("jms.connectionstring"));

			Context ctx = new InitialContext(props);
			
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup(config.getString("jms.lookup"));

			conn = qfactory.createQueueConnection();
			que = (Queue) ctx.lookup(config.getString("jms.queue.lookup"));
			session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);

			conn.start();
			initialized = true;
		}
	}
	
	public void setupPTP(String queueName) throws JMSException, NamingException {
		if (!initialized) {
			Hashtable<String, String> props = new Hashtable<String, String>();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(InitialContext.PROVIDER_URL, config.getString("jms.connectionstring"));
			
			Context ctx = new InitialContext(props);
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup(config.getString("jms.lookup"));

			conn = qfactory.createQueueConnection();
			que = (Queue) ctx.lookup(config.getString(queueName));
			session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);

			conn.start();
			initialized = true;
		}
	}

	public void sendRecvAsync(String text) throws JMSException, NamingException {
		logger.info("Begin sendRecvAsync");
		// Setup the PTP connection, session
		setupPTP();

		// Send a text msg
		QueueSender send = session.createSender(que);
		TextMessage tm = session.createTextMessage(text);
		send.send(tm);
		logger.info("sendRecvAsync, sent text=" + tm.getText());
		send.close();
		logger.info("End sendRecvAsync");
	}
	
	//paso el objeto tienda proque no se si se tiene que hacer algo con sus datos, de ultima si no se usa nada se pasa un string y a la bosta
	public void enviarOfad(String text,Tienda tienda) throws JMSException, NamingException{
		logger.info("Comenzando el envio a la tienda con la IP nro: "+tienda.getIp()+" nombre: "+tienda.getNombre());
		
		setupPTP(tienda.getQueueName());
		QueueSender send = session.createSender(que);
		TextMessage tm = session.createTextMessage(text);
		send.send(tm);
		logger.info("enviarOfad, texto enviado=" + tm.getText());
		send.close();
		logger.info("enviarOfad End");
	}

	public void enviarSolDist(String text, CentroDistribucion cd) throws JMSException, NamingException{
		logger.info("Comenzando el envio al centro de distribucion con IP nro: "+cd.getIp()+" y nombre: "+cd.getNombre());
		
		setupPTP(cd.getQueueName());
		QueueSender send = session.createSender(que);
		TextMessage tm = session.createTextMessage(text);
		send.send(tm);
		logger.info("enviarSolDist, texto enviado=" + tm.getText());
		send.close();
		logger.info("enviarSolDist End");
	}
	
	public void stop() throws JMSException {
		conn.stop();
		session.close();
		conn.close();
		initialized = false;
	}
}