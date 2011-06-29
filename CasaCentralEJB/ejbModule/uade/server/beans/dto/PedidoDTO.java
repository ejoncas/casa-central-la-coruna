package uade.server.beans.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uade.server.beans.ItemPedido;
import uade.server.beans.Pedido;
import uade.server.beans.dto.mapper.DTOMapper;

public class PedidoDTO {

	private Long id;
	private Date fechaPedido;
	private Boolean procesado;
	private List<ItemPedidoDTO> items;
	private TiendaDTO tienda;//Tienda que lo genero
	private CentroDistribucionDTO centroDeDistribucion;//Centro de distribucion que lo va a repartir finalmente
	
	public PedidoDTO() {}
	
	public PedidoDTO(Pedido p) {
		setCentroDeDistribucion((CentroDistribucionDTO) DTOMapper.map(p.getCentroDeDistribucion(), 
				CentroDistribucionDTO.class));
		setFechaPedido(p.getFechaPedido());
		setProcesado(p.getProcesado());
		setTienda((TiendaDTO) DTOMapper.map(p.getTienda(), TiendaDTO.class));
		this.items = new ArrayList<ItemPedidoDTO>();
		for(ItemPedido ip: p.getItems()){
			this.items.add(ip.getDTO());
		}
	}
	public Long getId() {
		return id;
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
	public List<ItemPedidoDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoDTO> items) {
		this.items = items;
	}
	public TiendaDTO getTienda() {
		return tienda;
	}
	public void setTienda(TiendaDTO tienda) {
		this.tienda = tienda;
	}
	public CentroDistribucionDTO getCentroDeDistribucion() {
		return centroDeDistribucion;
	}
	public void setCentroDeDistribucion(CentroDistribucionDTO centroDeDistribucion) {
		this.centroDeDistribucion = centroDeDistribucion;
	}
}
