package uade.server.modules;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uade.server.beans.Articulo;
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

	@SuppressWarnings("unchecked")
	public List<Articulo> obtenerArticulos() {
		 Query query = em.createQuery("SELECT a FROM Articulo a");
		 return (List<Articulo>) query.getResultList();
	}

	public void eliminarArticulo(Long ref) {
		Articulo articulo = em.find(Articulo.class, ref);
		em.remove(articulo);
	}

}
