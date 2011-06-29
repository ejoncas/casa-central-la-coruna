package uade.server.beans.dto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Palc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7207004559456515219L;
	private List<ItemPedidoXmlDTO> pedidos;
	private Integer idTienda;
	

	/**
	 * Public constructors
	 */
	public Palc(){
		this.pedidos = new ArrayList<ItemPedidoXmlDTO>();
	}
	public Palc(Integer idTienda){
		this.idTienda = idTienda;
		this.pedidos = new ArrayList<ItemPedidoXmlDTO>();
	}
	
	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
	public List<ItemPedidoXmlDTO> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<ItemPedidoXmlDTO> pedidos) {
		this.pedidos = pedidos;
	}
}
