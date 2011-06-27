package uade.server.beans.dto;

import java.io.Serializable;
import java.util.List;

import uade.server.beans.dto.xml.ItemPedidoXml2DTO;
import uade.server.beans.dto.xml.ItemPedidoXmlDTO;

public class EnvioDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -129090101480079914L;
	private Long idTienda;
	//IMPLICIT Collection
	private List<ItemPedidoXml2DTO> pedidos;
	
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public List<ItemPedidoXml2DTO> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<ItemPedidoXml2DTO> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
