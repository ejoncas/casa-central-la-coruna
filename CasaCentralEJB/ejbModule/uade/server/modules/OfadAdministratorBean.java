package uade.server.modules;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OfadAdministratorBean implements OfadAdministrator{
	
	@PersistenceContext 
    private EntityManager em;

}
