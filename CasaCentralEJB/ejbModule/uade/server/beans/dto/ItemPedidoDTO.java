package uade.server.beans.dto;

import java.io.Serializable;

public class ItemPedidoDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222443063167287864L;
	private Long id;
	private ArticuloDTO articulo;
	private Integer cantidad;
	//ommited field
	private Float precioVenta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ArticuloDTO getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
	
}
