package uade.server.beans.dto;

import java.io.Serializable;
import java.util.List;

import uade.server.beans.ItemPedido;
import uade.server.beans.Tienda;

public class PedidoDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -501843228471240121L;
	private List<ItemPedido> items;
	private Tienda tienda;
	
	public List<ItemPedido> getItems() {
		return items;
	}
	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
	
	
}
