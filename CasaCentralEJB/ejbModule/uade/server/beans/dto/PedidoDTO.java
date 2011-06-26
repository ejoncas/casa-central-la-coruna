package uade.server.beans.dto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {

	private Long id;
	private Date fechaPedido;
	private Boolean procesado;
	private List<ItemPedidoDTO> items;
	private TiendaDTO tienda;//Tienda que lo genero
	private CentroDistribucionDTO centroDeDistribucion;//Centro de distribucion que lo va a repartir finalmente
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
