package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import uade.server.beans.dto.ItemPedidoDTO;

@Entity
public class ItemPedido {

	@Id @GeneratedValue
	private Long id;
	@OneToOne
	private Articulo articulo;
	private Integer cantidad;
	private Float precioVenta;
	
	
	public ItemPedido() {
		super();
	}
	public ItemPedido(Articulo art, Integer cantidad) {
		super();
		this.articulo=art;
		this.cantidad=cantidad;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public ItemPedidoDTO getDTO(){
		ItemPedidoDTO dto = new ItemPedidoDTO();
		dto.setArticulo(articulo.getDTO());
		dto.setCantidad(cantidad);
		dto.setPrecioVenta(precioVenta);
		dto.setId(id);
		return dto;
	}
	
}
