package uade.server.beans.mdb;

import java.util.Hashtable;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

//Especifico tipo y nombre logico de la cola de destino
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/queueLC1") })
public class EnviarSolDistMessage implements MessageListener {

	public void onMessage(Message arg0) {

		// get the initial context
		/*PropertiesConfiguration config = new PropertiesConfiguration("config.properties");
		Hashtable<String, String> props = new Hashtable<String,String>();
		props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		props.put(InitialContext.PROVIDER_URL,config.getString("naming.url"));
		InitialContext ic;
		InitialContext ctx = new InitialContext(props);

		// lookup the queue object
		Queue queue = (Queue) ctx.lookup("queue/queueLC1");
		// lookup the queue connection factory
		QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup("queue/connectionFactory");

		// create a queue connection
		QueueConnection queueConn = connFactory.createQueueConnection();
		// create a queue session
		QueueSession queueSession = queueConn.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
		// create a queue sender
		QueueSender queueSender = queueSession.createSender(queue);
		queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		// create a simple message to say "Hello"
		TextMessage message = queueSession.createTextMessage("Hello");
		// send the message
		queueSender.send(message);
		// print what we did
		System.out.println("sent: " + message.getText());

		// close the queue connection
		queueConn.close();*/
	}

}
