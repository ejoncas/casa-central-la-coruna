package uade.server.beans.dto;

import java.util.List;

public class SolDistDTO {
	
	private Long id;
	private CentroDistribucionDTO centroDistribucion;
	private List<PedidoDTO> pedidosAEntregar;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CentroDistribucionDTO getCentroDistribucion() {
		return centroDistribucion;
	}
	public void setCentroDistribucion(CentroDistribucionDTO centroDistribucion) {
		this.centroDistribucion = centroDistribucion;
	}
	public List<PedidoDTO> getPedidosAEntregar() {
		return pedidosAEntregar;
	}
	public void setPedidosAEntregar(List<PedidoDTO> pedidosAEntregar) {
		this.pedidosAEntregar = pedidosAEntregar;
	}
	
}
