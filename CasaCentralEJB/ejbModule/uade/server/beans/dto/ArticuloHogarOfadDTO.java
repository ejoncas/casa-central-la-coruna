package uade.server.beans.dto;

import java.io.Serializable;


public class ArticuloHogarOfadDTO extends ArticuloOfadDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8962428541039166128L;
	private String nombre;
	private String composicion;
	private String medidas;
	private String categoria;
	
	
	
	public ArticuloHogarOfadDTO(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion, String categoria,
			String composicion, String medidas, String nombre) {
		super(color, descripcion, linea, precio, referencia, seccion);
		this.categoria = categoria;
		this.composicion = composicion;
		this.medidas = medidas;
		this.nombre = nombre;
	}
	
	public ArticuloHogarOfadDTO(ArticuloHogarDTO dto){
			super(dto);
			this.nombre = dto.getNombre();
			this.composicion = dto.getComposicion();
			this.medidas = dto.getMedidas();
			this.categoria = dto.getCategoria();
	}
	
	public ArticuloHogarOfadDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComposicion() {
		return composicion;
	}
	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	

}
