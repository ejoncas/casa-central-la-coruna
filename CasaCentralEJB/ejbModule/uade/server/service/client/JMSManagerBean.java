package uade.server.service.client;

import java.util.Hashtable;

import javax.ejb.Stateless;
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


@Stateless
public class JMSManagerBean implements JMSManager {

	
	private final static Logger logger = LoggerFactory.getLogger(JMSManagerBean.class);
	private static final String CONNECTION_FACTORY = "ConnectionFactory";

	private PropertiesConfiguration config;
	
	public JMSManagerBean() throws ConfigurationException {
		config = new PropertiesConfiguration("config.properties");
	}

	public void enviarMensajeFabrica(String text){
		logger.debug("Enviando mensaje a la fabrica");
		QueueConnection conn = null;
		QueueSession session = null;
		QueueSender send = null;
		try {

			// Setup the PTP connection, session
			Context ctx = new InitialContext(getJmsPropiertiesForHost(config.getString("jms.connectionstring")));
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup(CONNECTION_FACTORY);
			
			conn = qfactory.createQueueConnection();
			Queue queue = (Queue) ctx.lookup(config.getString("jms.queue.lookup"));
			session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			conn.start();
			
			//Send Message
			send = session.createSender(queue);
			TextMessage tm = session.createTextMessage(text);
			send.send(tm);
			
			logger.debug("Mensaje enviado a la fabrica satisfactoriamente. Mensaje [" + tm.getText() + "]");
			
		} catch (NamingException e) {
			e.printStackTrace();
			logger.debug("NAMING ERROR", e);
		} catch (JMSException e) {
			e.printStackTrace();
			logger.debug("JMS ERROR", e);
		} finally {
			coseSafely(conn, session, send);
		}
	}



	public void enviarOfadATienda(String text, Tienda tienda) {
		logger.debug("Comenzando el envio a la tienda con la IP nro: "+tienda.getJmsConnectionString()+" nombre: "+tienda.getNombre());
		QueueConnection conn = null;
		QueueSession session = null;
		QueueSender send = null;
		try{
			//Config and get Connection
			Context ctx = new InitialContext(getJmsPropiertiesForHost(tienda.getJmsConnectionString()));
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup(CONNECTION_FACTORY);
			
			conn = qfactory.createQueueConnection();
			Queue queue = (Queue) ctx.lookup(tienda.getQueueName());
			session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			conn.start();
			
			//Send Message
			send = session.createSender(queue);
			TextMessage tm = session.createTextMessage(text);
			send.send(tm);
			
			logger.debug("Mensaje enviado a la tienda satisfactoriamente. Mensaje [ " + text +  "]. Tienda [" + tienda.getNombre() + "]");
			
		} catch (NamingException e) {
			e.printStackTrace();
			logger.debug("NAMING ERROR", e);
		} catch (JMSException e) {
			e.printStackTrace();
			logger.debug("JMS ERROR", e);
		} finally {
			coseSafely(conn, session, send);
		}
	}
	
	
	public void enviarMensajeACentroDistribucion(String xml, CentroDistribucion cd) {
		logger.debug("Comenzando el envio al CD con la IP nro: "+cd.getJmsConnectionString()+" nombre: "+cd.getNombre());
		QueueConnection conn = null;
		QueueSession session = null;
		QueueSender send = null;
		try {
			//Config and get Connection
			Context ctx = new InitialContext(getJmsPropiertiesForHost(cd.getJmsConnectionString()));
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup(CONNECTION_FACTORY);
			
			conn = qfactory.createQueueConnection();
			Queue queue = (Queue) ctx.lookup(cd.getQueueName());
			session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			conn.start();
			
			
			//Send Message
			send = session.createSender(queue);
			TextMessage tm = session.createTextMessage(xml);
			send.send(tm);
			
			logger.debug("Mensaje enviado al CD satisfactoriamente. Mensaje [ " + xml +  "]. CD [" + cd.getNombre() + "]");
			
		} catch (NamingException e) {
			e.printStackTrace();
			logger.debug("NAMING ERROR", e);
		} catch (JMSException e) {
			e.printStackTrace();
			logger.debug("JMS ERROR", e);
		} finally {
			coseSafely(conn, session, send);
		}
	}

	private Hashtable<String, String> getJmsPropiertiesForHost(String lookup) {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		props.put(InitialContext.PROVIDER_URL, lookup);
		return props;
	}
	

	private void coseSafely(QueueConnection conn, QueueSession session,
			QueueSender send) {
		try { send.close(); } catch (Throwable e) {}
		try { conn.stop();} catch (Throwable e) {}
		try { session.close();} catch (Throwable e) {}
	}

}