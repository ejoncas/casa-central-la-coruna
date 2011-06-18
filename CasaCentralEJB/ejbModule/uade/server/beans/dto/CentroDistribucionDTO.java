package uade.server.beans.dto;

import java.io.Serializable;

public class CentroDistribucionDTO  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7402204871108941972L;
	private Long id;
    private double latitud;
    private double longitud;
    private String nombre;
    
    
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
	public CentroDistribucionDTO(double latitud, double longitud, String nombre) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
	}
    
    public CentroDistribucionDTO(){}
    public CentroDistribucionDTO(Long id){
    	this.id = id; 
    }
    public Long getId() {
            return id;
    }
    public void setId(Long id) {
            this.id = id;
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
