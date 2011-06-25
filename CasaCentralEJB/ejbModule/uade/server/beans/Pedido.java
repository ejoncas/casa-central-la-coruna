package uade.server.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido{
	
	@Id @GeneratedValue
	private Long id;
	private Date fechaPedido;
	private Boolean procesado;
	@OneToMany
	private List<ItemPedido> items;
	@OneToOne
	private Tienda tienda;//Tienda que lo genero
	@OneToOne
	private CentroDistribucion centroDeDistribucion;//Centro de distribucion que lo va a repartir finalmente
	
	public Pedido() {
		super();
		this.centroDeDistribucion = new CentroDistribucion();
		this.items = new ArrayList<ItemPedido>();
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

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Boolean getProcesado() {
		return procesado;
	}

	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}
	
	/**
	 * Agrega uin Item pedido al pedido
	 * @param ip
	 */
	public void addItemPedido(ItemPedido ip){
		if(this.items == null)
			this.items = new ArrayList<ItemPedido>();
		this.items.add(ip);
	}
	
}
