package uade.server.beans.dto;

import java.io.Serializable;

public class TiendaDTO  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4826670371298380655L;
	private Long id;
    private double latitud;
    private double longitud;
    private String nombre;
    
    public TiendaDTO(String string, double d, double e) {
    	this.nombre = string;
    	this.latitud = d;
    	this.longitud = e;
	}
	public TiendaDTO() {}
	public Long getId() {
            return id;
    }
    public void setId(Long id) {
            this.id = id;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
    
    
}