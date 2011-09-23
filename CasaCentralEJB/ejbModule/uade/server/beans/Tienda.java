package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import uade.server.beans.dto.TiendaDTO;

@Entity
public class Tienda {

	@Id
	private Long id;
	private double latitud;
	private double longitud;
	private String nombre;
	private String queueName;
	private String jmsConnectionString;

	public Tienda() {
	}

	public Tienda(Long id) {
		this.id = id;
	}

	public Tienda(TiendaDTO tienda) {
		this.latitud = tienda.getLatitud();
		this.longitud = tienda.getLongitud();
		this.nombre = tienda.getNombre();
	}

	public Tienda(String nombre, double lat, double longi) {
		this.nombre = nombre;
		this.latitud = lat;
		this.longitud = longi;
	}
	
    //lomantog - nuevo constructor para setear un id especifico a las tiendas
    public Tienda(Long id, String string, double d, double e) {
    	this.id = id;
    	this.nombre = string;
    	this.latitud = d;
    	this.longitud = e;
	}

	public Long getId() {
		return id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getJmsConnectionString() {
		return jmsConnectionString;
	}

	public void setJmsConnectionString(String jmsConnectionString) {
		this.jmsConnectionString = jmsConnectionString;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

}