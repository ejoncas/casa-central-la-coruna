package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CentroDistribucion {

	@Id
	private Long id;
	private double latitud;
	private double longitud;
	private String nombre;
	private String endpoint;
	private String queueName;
	private String jmsConnectionString;

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
	
	//lomantog - nuevo constructor para setear un id especifico a los centros de distribucion
	public CentroDistribucion(Long id, double latitud, double longitud, String nombre) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
	}

	public CentroDistribucion() {
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

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getJmsConnectionString() {
		return jmsConnectionString;
	}

	public void setJmsConnectionString(String jmsConnectionString) {
		this.jmsConnectionString = jmsConnectionString;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
