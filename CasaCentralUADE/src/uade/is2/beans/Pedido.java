package uade.is2.beans;

public class Pedido{
	private Integer referencia;
	//private String categoria;
	private Integer cantidad;
	public Pedido(Integer cantidad, Integer referencia) {
		super();
		this.cantidad = cantidad;
		this.referencia = referencia;
	}
	public Integer getReferencia() {
		return referencia;
	}
	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
