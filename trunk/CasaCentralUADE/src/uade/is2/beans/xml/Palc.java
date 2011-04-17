package uade.is2.beans.xml;

import java.util.ArrayList;
import java.util.List;

import uade.is2.beans.Pedido;

public class Palc {
	
	private List<Pedido> pedidos;
	private Integer idTienda;
	

	/**
	 * Public constructors
	 */
	public Palc(){
		this.pedidos = new ArrayList<Pedido>();
	}
	public Palc(Integer idTienda){
		this.idTienda = idTienda;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Integer getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
	
	public void addPedido(Integer ref, Integer cant){
		this.pedidos.add(new Pedido(ref,cant));
	}
}
