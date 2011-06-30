package uade.server.beans.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ArticuloDTO implements Serializable{
	
	@Override
	public String toString() {
		return "ID: "+referencia+" - Seccion: "+seccion+" - Precio: "+precio+" - Color: "+this.color+" - Linea: "+this.linea+
		" - Descripcion: "+this.descripcion;
	}	
	private Long referencia;
	private String seccion;
	private Float precio;
	private String color;
	private String linea;
	private Date mesRebaja;
	private String descripcion;
	private String type;
	private List<CentroDistribucionDTO> centros;
	private Float descuento;
	
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
		this.color = "";
		this.descripcion = "";
		this.linea = "";
		this.seccion = "";
		this.descuento = 0.0f;
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

	public Date getMesRebaja() {
		return mesRebaja;
	}

	public void setMesRebaja(Date mesRebaja) {
		this.mesRebaja = mesRebaja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ArticuloDTO other = (ArticuloDTO) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	
}
