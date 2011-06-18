package uade.server.beans.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ArticuloDTO implements Serializable{
	
	private Long referencia;
	private String seccion;
	private Float precio;
	private String color;
	private String linea;
	private String descripcion;
	private String type;
	private List<CentroDistribucionDTO> centros;
	
	/* TYPES */
	public static String TYPE_ROPA = "Ropa";
	public static String TYPE_HOGAR = "Hogar";
	
	
	public ArticuloDTO(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion) {
		super();
		this.color = color;
		this.descripcion = descripcion;
		this.linea = linea;
		this.precio = precio;
		this.referencia = referencia;
		this.seccion = seccion;
		centros = new ArrayList<CentroDistribucionDTO>();
	}
	
	public ArticuloDTO() {
		super();
		centros = new ArrayList<CentroDistribucionDTO>();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CentroDistribucionDTO> getCentros() {
		return centros;
	}

	public void setCentros(List<CentroDistribucionDTO> centros) {
		this.centros = centros;
	}
	
	
}
