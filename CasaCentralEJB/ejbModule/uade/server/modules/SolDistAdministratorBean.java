package uade.server.modules;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uade.server.beans.CentroDistribucion;

@Stateless
public class SolDistAdministratorBean implements SolDistAdministrator{

	@PersistenceContext 
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<CentroDistribucion> obtenerCentrosDeDistribucion() {
		Query query = em.createQuery("SELECT a FROM CentroDistribucion a");
		return (List<CentroDistribucion>) query.getResultList();
	}

	public void nuevoCentroDeDistribucion(CentroDistribucion cd) {
		em.persist(cd);
	}
	
	
}
