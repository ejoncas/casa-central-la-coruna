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
    private String ip;
    private String queueName;
    
    
    
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
	
	//lomantog - nuevo constructor para setear un id especifico a los centros de distribucion
	public CentroDistribucionDTO(Long id, double latitud, double longitud, String nombre) {
		super();
		this.id = id;
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
    
}
