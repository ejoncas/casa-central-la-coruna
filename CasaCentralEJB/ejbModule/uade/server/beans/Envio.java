package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Envio {

	@Id @GeneratedValue
	private Long id;
	private Long idTienda;
	private String referencia;
	//private String categoria;
	private Integer cantidad;
	
	public Envio() {
		super();
	}
	public Envio(Integer cantidad, Long idTienda, String referencia) {
		super();
		this.cantidad = cantidad;
		this.idTienda = idTienda;
		this.referencia = referencia;
	}
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
