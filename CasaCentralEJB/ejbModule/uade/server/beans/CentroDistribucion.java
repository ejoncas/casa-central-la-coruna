
package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CentroDistribucion {

	@Id @GeneratedValue
    private Long id;
    private double latitud;
    private double longitud;
    private String nombre;
    private String ip;
    private String queueName;
    
    
    
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
    public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Override
    public String toString(){
    	return this.nombre;
    }
    
    
}
