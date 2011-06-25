package uade.server.modules;

import javax.ejb.Local;

import uade.server.beans.Pedido;
import uade.server.beans.Tienda;

@Local
public interface PalcAdministrator {

	
	void ingresarPedido(Pedido p);

	void nuevaTienda(Tienda tienda);

}
