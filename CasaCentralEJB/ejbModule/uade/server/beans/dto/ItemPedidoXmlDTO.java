package uade.server.beans.dto;

import java.io.Serializable;

public class ItemPedidoXmlDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222443063167287864L;
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
