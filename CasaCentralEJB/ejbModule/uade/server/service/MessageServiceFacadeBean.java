package uade.server.service;

import javax.ejb.EJB;

import uade.server.CasaCentral;

public class MessageServiceFacadeBean {
	
	@EJB
	private CasaCentral casaCentral;


	public void setCasaCentral(CasaCentral casaCentral) {
		this.casaCentral = casaCentral;
	}
}
