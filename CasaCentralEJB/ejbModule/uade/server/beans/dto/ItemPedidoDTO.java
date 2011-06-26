package uade.server.beans.dto;

import java.io.Serializable;
import java.util.List;

import uade.server.beans.ItemPedido;
import uade.server.beans.Tienda;

public class ItemPedidoDTO  implements Serializable{
	/**
	 * 
	 */
	private transient static final long serialVersionUID = -501843228471240121L;
	private String ref;
	private Integer cantidad;
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
