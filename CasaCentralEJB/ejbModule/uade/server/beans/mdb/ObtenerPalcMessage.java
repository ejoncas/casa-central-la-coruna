package uade.server.beans.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import uade.server.CasaCentral;
import uade.server.beans.dto.TiendaDTO;
import uade.server.beans.dto.xml.Palc;
import uade.server.exception.CasaCentralException;

//Especifico tipo y nombre logico de la cola de destino
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="queue/queueLC1")
	})
public class ObtenerPalcMessage implements MessageListener {

	private static final Logger logger = Logger.getLogger(ObtenerPalcMessage.class);
	private CasaCentral casaCentral;
	private Palc palc = new Palc();
	private TiendaDTO tienda = new TiendaDTO();
	
	public void onMessage(Message msg) {
		if((msg != null)&&((msg instanceof TextMessage))) {
			try {
				TextMessage txtMsg = (TextMessage) msg;
				System.out.println("MDB recibido con contenido: "+txtMsg.getText());
				//TODO: [lomantog] Armo el Palc y se lo mando al facade
				casaCentral.ingresarPredido(palc, tienda);
			} catch (JMSException e) {
				logger.error("JMS Exception en PalcMessage, causa: ", e);
			} catch (CasaCentralException e) {
				logger.error("CasaCentralException en PalcMessage, causa: ", e);
			}
		}
	}
}
