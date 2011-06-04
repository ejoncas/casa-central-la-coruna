package uade.server.beans;


import javax.persistence.Entity;

import uade.server.bean.dto.ArticuloHogarDTO;

@Entity
public class ArticuloHogar extends Articulo{
	
	private String nombre;
	private String composicion;
	private String medidas;
	private String categoria;
	
	
	
	public ArticuloHogar(String color, String descripcion, String linea,
			Float precio, Long referencia, String seccion, String categoria,
			String composicion, String medidas, String nombre) {
		super(color, descripcion, linea, precio, referencia, seccion);
		this.categoria = categoria;
		this.composicion = composicion;
		this.medidas = medidas;
		this.nombre = nombre;
	}
	
	public ArticuloHogar() {
		super();
	}

	public ArticuloHogar(ArticuloHogarDTO a) {
		this.categoria = a.getCategoria();
		this.composicion = a.getComposicion();
		this.medidas = a.getMedidas();
		this.nombre = a.getNombre();
		setColor(a.getColor());
		setSeccion(a.getSeccion());
		setPrecio(a.getPrecio());
		setLinea(a.getLinea());
		setDescripcion(a.getDescripcion());
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
