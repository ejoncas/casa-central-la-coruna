package uade.server.beans.mdb;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

//Especifico tipo y nombre logico de la cola de destino
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="queue/queueLC1")
	})
public class EnviarOfadMessage implements MessageListener {

	public void onMessage(Message msg) {

	}

}
