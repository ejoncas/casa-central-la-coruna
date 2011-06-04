package uade.server.modules;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uade.server.beans.ArticuloHogar;
import uade.server.beans.ArticuloRopa;

@Stateless
public class NuevoArtAdministratorBean implements NuevoArtAdministrator{

	@PersistenceContext 
    private EntityManager em;
	
	public void nuevoArtCasa(ArticuloHogar ah) {
		em.persist(ah);
	}

	public void nuevoArtRopa(ArticuloRopa ar) {
		em.persist(ar);
	}

}
