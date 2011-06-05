package uade.server.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import uade.server.beans.dto.PedidoDTO;

@Entity
public class Pedido{
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToMany
	private List<ItemPedido> items;
	@OneToOne
	private Tienda tienda;//Tienda que lo genero
	@OneToOne
	private CentroDistribucion centroDeDistribucion;//Centro de distribucion que lo va a repartir finalmente
	
	public Pedido() {
		super();
	}
	
	/**
	 * DTO Constructor
	 * @param pedido
	 */
	public Pedido(PedidoDTO pedido) {
		this.items = pedido.getItems();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public CentroDistribucion getCentroDeDistribucion() {
		return centroDeDistribucion;
	}

	public void setCentroDeDistribucion(CentroDistribucion centroDeDistribucion) {
		this.centroDeDistribucion = centroDeDistribucion;
	}
	
	
	
	
}
