package uade.server.beans.dto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uade.server.beans.dto.ItemPedidoDTO;

public class Palc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7207004559456515219L;
	private List<ItemPedidoDTO> pedidos;
	private Integer idTienda;
	

	/**
	 * Public constructors
	 */
	public Palc(){
		this.pedidos = new ArrayList<ItemPedidoDTO>();
	}
	public Palc(Integer idTienda){
		this.idTienda = idTienda;
		this.pedidos = new ArrayList<ItemPedidoDTO>();
	}
	
	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public List<ItemPedidoDTO> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<ItemPedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	public Integer getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
}
