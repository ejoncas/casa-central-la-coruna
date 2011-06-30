package uade.server.beans.dto;

import java.io.Serializable;


public class ArticuloRopaDTO extends ArticuloDTO  implements Serializable{
	
	
	@Override
	public String toString() {
		return super.toString()+" - Talle: "+this.talle+" - Origen: "+this.origen;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -2764986829148373241L;
	private String talle;
	private String origen;
	
	
	
	
	public ArticuloRopaDTO(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion, String origen,
			String talle) {
		super(color, descripcion, linea, precio, referencia, seccion);
		this.origen = origen;
		this.talle = talle;
	}
	public ArticuloRopaDTO() {
		super();
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
