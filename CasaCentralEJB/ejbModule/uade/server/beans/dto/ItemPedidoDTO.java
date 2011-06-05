package uade.server.beans.dto;


public class ItemPedidoDTO {

	private Long id;
	private Long referencia;
	private Integer cantidad;
	
	
	public ItemPedidoDTO() {
		super();
	}
	public ItemPedidoDTO(Long referencia, Integer cantidad) {
		super();
		this.referencia = referencia;
		this.cantidad = cantidad;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getReferencia() {
		return referencia;
	}
	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}
	public Long getId() {
		return id;
	}

	
}
