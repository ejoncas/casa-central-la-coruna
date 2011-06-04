package uade.server.modules;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uade.server.beans.Pedido;

@Stateless
public class PalcAdministratorBean implements PalcAdministrator{

	@PersistenceContext 
    private EntityManager em;

	public void ingresarPedido(Pedido p) {
		// TODO Definir a que centro de distribucion debo llevar el pedido
		
		
		
	}
}
