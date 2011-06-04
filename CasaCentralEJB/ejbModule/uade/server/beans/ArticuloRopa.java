package uade.server.beans;

import javax.persistence.Entity;

import uade.server.bean.dto.ArticuloRopaDTO;

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
		setColor(a.getColor());
		setSeccion(a.getSeccion());
		setPrecio(a.getPrecio());
		setLinea(a.getLinea());
		setDescripcion(a.getDescripcion());
		this.origen = a.getOrigen();
		this.talle = a.getTalle();
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
	
	
	
	

}
