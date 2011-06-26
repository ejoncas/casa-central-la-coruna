package uade.server.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SolDist {
	
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private CentroDistribucion centroDistribucion;
	@OneToMany
	private List<Pedido> pedidosAEntregar;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CentroDistribucion getCentroDistribucion() {
		return centroDistribucion;
	}
	public void setCentroDistribucion(CentroDistribucion centroDistribucion) {
		this.centroDistribucion = centroDistribucion;
	}
	public List<Pedido> getPedidosAEntregar() {
		return pedidosAEntregar;
	}
	public void setPedidosAEntregar(List<Pedido> pedidosAEntregar) {
		this.pedidosAEntregar = pedidosAEntregar;
	}
	

}
