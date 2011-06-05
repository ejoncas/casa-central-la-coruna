
package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CentroDistribucion {

	@Id @GeneratedValue
    private int id;
    private double latitud;
    private double longitud;
    private String nombre;
    
    
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CentroDistribucion(double latitud, double longitud, String nombre) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
	}
    
    public CentroDistribucion(){}
	public int getId() {
            return id;
    }
    public void setId(int id) {
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
    
    @Override
    public String toString(){
    	return this.nombre;
    }
    
}
