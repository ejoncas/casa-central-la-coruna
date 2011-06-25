package uade.server.beans;

import java.util.Date;

import javax.persistence.Entity;

import uade.server.beans.dto.ArticuloDTO;
import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;

@Entity
public class ArticuloRopa extends Articulo{
	
	private String talle;
	private String origen;
	
	public ArticuloRopa(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion, String origen,
			String talle) {
		super(color, descripcion, linea, precio, referencia, seccion);
		this.origen = origen;
		this.talle = talle;
	}
	public ArticuloRopa() {
		super();
	}
	public ArticuloRopa(ArticuloRopaDTO a) {
		super();
		setColor(a.getColor());
		setSeccion(a.getSeccion());
		setPrecio(a.getPrecio());
		setLinea(a.getLinea());
		setDescripcion(a.getDescripcion());
		this.origen = a.getOrigen();
		this.talle = a.getTalle();
		setMesRebaja(a.getMesRebaja());
		setFechaAlta(new Date());
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	@Override
	public ArticuloDTO getDTO() {
		ArticuloRopaDTO dto = new ArticuloRopaDTO();
		dto.setColor(getColor());
		dto.setDescripcion(getDescripcion());
		dto.setLinea(getLinea());
		dto.setOrigen(getOrigen());
		dto.setPrecio(getPrecio());
		dto.setReferencia(getReferencia());
		dto.setSeccion(getSeccion());
		dto.setTalle(getTalle());
		dto.setType(ArticuloHogarDTO.TYPE_ROPA);
		dto.setMesRebaja(getMesRebaja());
		return dto;
	}
	

}
