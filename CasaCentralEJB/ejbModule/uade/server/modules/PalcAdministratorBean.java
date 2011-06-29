package uade.server.modules;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uade.server.beans.CentroDistribucion;
import uade.server.beans.ItemPedido;
import uade.server.beans.Pedido;
import uade.server.beans.Tienda;
import uade.server.beans.logic.CentroDeDistribucionLocator;

@Stateless
public class PalcAdministratorBean implements PalcAdministrator{

	@PersistenceContext 
    private EntityManager em;
	
	private CentroDeDistribucionLocator locator;

	public PalcAdministratorBean(){
		locator = new CentroDeDistribucionLocator();
	}
	
	@SuppressWarnings("unchecked")
	private List<CentroDistribucion> getCentrosDistribucion() {
		Query query = em.createQuery("SELECT a FROM CentroDistribucion a");
		return (List<CentroDistribucion>) query.getResultList();
	}

	public void ingresarPedido(Pedido p) {
		Tienda tienda  = getTiendaById(p.getTienda().getId());
		p.getFechaPedido().setMonth(3);
		CentroDistribucion cdMasCercano = locator.obtenerCentroMasCercano(tienda, getCentrosDistribucion());
		
		p.setCentroDeDistribucion(cdMasCercano);
		//persistimos los items pedidos
		for(ItemPedido ip : p.getItems())
			em.persist(ip);
		//luego el pedido
		em.persist(p);
	}
	
	private Tienda getTiendaById(Long id){
		 Query query = em.createQuery("SELECT t FROM Tienda t WHERE t.id=?").setParameter(1, id);
		 return (Tienda) query.getSingleResult();
	}

	/**
	 * Persist tienda entity and generates id
	 */
	public void nuevaTienda(Tienda tienda) {
		em.persist(tienda);
	}

	public Tienda getTienda(Long id) {
		return em.find(Tienda.class, id);
	}
}
