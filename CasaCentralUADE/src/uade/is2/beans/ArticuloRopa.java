package uade.is2.beans;

public class ArticuloRopa extends Articulo{
	
	private String talle;
	private String origen;
	
	
	
	
	public ArticuloRopa(String color, String descripcion, String linea,
			Float precio, Integer referencia, String seccion, String origen,
			String talle) {
		super(color, descripcion, linea, precio, referencia, seccion);
		this.origen = origen;
		this.talle = talle;
	}
	public ArticuloRopa() {
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
