package uade.server.bean.dto;

import java.io.Serializable;

public class EnvioDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -129090101480079914L;
	private Integer idTienda;
	private String referencia;
	//private String categoria;
	private Integer cantidad;
	
	
	
	public EnvioDTO() {
		super();
	}
	public EnvioDTO(Integer cantidad, Integer idTienda, String referencia) {
		super();
		this.cantidad = cantidad;
		this.idTienda = idTienda;
		this.referencia = referencia;
	}
	public Integer getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
