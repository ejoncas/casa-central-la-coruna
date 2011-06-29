package uade.server.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uade.server.beans.dto.ArticuloDTO;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Articulo {
	
	@Id @GeneratedValue
	private Long referencia;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;
	private String seccion;
	private Float precio;
	private Date mesRebaja;
	private String color;
	private String linea;
	private String descripcion;
	@ManyToMany
	private List<CentroDistribucion> centros;
	
	
	public Articulo(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion) {
		super();
		this.color = color;
		this.descripcion = descripcion;
		this.linea = linea;
		this.precio = precio;
		this.referencia = referencia;
		this.seccion = seccion;
		this.fechaAlta = new Date();
		centros = new ArrayList<CentroDistribucion>();
	}
	
	public Articulo() {
		super();
		centros = new ArrayList<CentroDistribucion>();
		fechaAlta = new Date();
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
	
	public abstract ArticuloDTO getDTO();

	public List<CentroDistribucion> getCentros() {
		return centros;
	}

	public void setCentros(List<CentroDistribucion> centros) {
		this.centros = centros;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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
		final Articulo other = (Articulo) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

	
	
}
