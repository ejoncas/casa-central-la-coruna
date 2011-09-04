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

			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");

			props.put(InitialContext.PROVIDER_URL, config
					.getString("jms.connectionstring"));

			Context ctx = new InitialContext(props);
			
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx
					.lookup(config.getString("jms.lookup"));

			conn = qfactory.createQueueConnection();
			que = (Queue) ctx.lookup(config.getString("jms.queue.lookup"));
			session = conn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

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

	public void stop() throws JMSException {
		conn.stop();
		session.close();
		conn.close();
		initialized = false;
	}
	

}