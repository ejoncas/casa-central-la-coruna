package uade.server.modules;

import javax.ejb.Local;

import uade.server.beans.Pedido;

@Local
public interface PalcAdministrator {

	
	void ingresarPedido(Pedido p);

}
