package uade.server.beans.dto;

import java.io.Serializable;

public abstract class ArticuloDTO implements Serializable{
	
	private Long referencia;
	private String seccion;
	private Float precio;
	private String color;
	private String linea;
	private String descripcion;
	
	
	public ArticuloDTO(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion) {
		super();
		this.color = color;
		this.descripcion = descripcion;
		this.linea = linea;
		this.precio = precio;
		this.referencia = referencia;
		this.seccion = seccion;
	}
	
	public ArticuloDTO() {
		super();
	}

	public Long getReferencia() {
		return referencia;
	}
	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

	
}