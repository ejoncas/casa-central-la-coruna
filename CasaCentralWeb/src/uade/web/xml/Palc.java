package uade.web.xml;

import java.util.ArrayList;
import java.util.List;

import uade.server.bean.dto.PedidoDTO;

public class Palc {
	
	private List<PedidoDTO> pedidos;
	private Integer idTienda;
	

	/**
	 * Public constructors
	 */
	public Palc(){
		this.pedidos = new ArrayList<PedidoDTO>();
	}
	public Palc(Integer idTienda){
		this.idTienda = idTienda;
		this.pedidos = new ArrayList<PedidoDTO>();
	}
	
	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	public Integer getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
}
