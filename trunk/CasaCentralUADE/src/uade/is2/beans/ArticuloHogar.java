package uade.is2.beans;

public class ArticuloHogar extends Articulo{
	
	private String nombre;
	private String composicion;
	private String medidas;
	private String categoria;
	
	
	
	public ArticuloHogar(String color, String descripcion, String linea,
			Float precio, Integer referencia, String seccion, String categoria,
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
