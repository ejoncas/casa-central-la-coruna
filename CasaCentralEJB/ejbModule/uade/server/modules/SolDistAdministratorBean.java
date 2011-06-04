package uade.server.modules;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SolDistAdministratorBean implements SolDistAdministrator{

	@PersistenceContext 
    private EntityManager em;
	
	
}
