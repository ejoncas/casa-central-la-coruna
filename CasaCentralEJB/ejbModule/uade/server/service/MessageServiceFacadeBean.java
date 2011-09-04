package uade.server.service;

import javax.ejb.EJB;

import uade.server.CasaCentral;

/**
 * FIXME Creo que en esta clase no hay que hacer nada, por lo que vi
 * en el documento todos los mensajes jms los tenemos que enviar, es decir que
 * no tenemos que recibir nada... por ende no tendriamos que tener un message facade ni un
 * MDB ni nada. Solo un connection lookup a la queue del grupo y enviar.
 *  
 * @author jonatan
 */
public class MessageServiceFacadeBean {
	
	@EJB
	private CasaCentral casaCentral;


	public void setCasaCentral(CasaCentral casaCentral) {
		this.casaCentral = casaCentral;
	}
}
