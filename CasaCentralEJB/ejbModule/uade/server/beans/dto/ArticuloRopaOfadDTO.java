package uade.server.beans.dto;

import java.io.Serializable;


public class ArticuloRopaOfadDTO extends ArticuloOfadDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2764986829148373241L;
	private String talle;
	private String origen;
	
	
	
	
	public ArticuloRopaOfadDTO(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion, String origen,
			String talle) {
		super(color, descripcion, linea, precio, referencia, seccion);
		this.origen = origen;
		this.talle = talle;
	}
	public ArticuloRopaOfadDTO() {
		super();
	}
	
	public ArticuloRopaOfadDTO(ArticuloRopaDTO dto){
		super(dto);
		this.talle = dto.getTalle();
		this.origen = dto.getOrigen();
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
