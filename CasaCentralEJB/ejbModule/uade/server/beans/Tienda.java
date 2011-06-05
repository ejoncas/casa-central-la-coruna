package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import uade.server.beans.dto.TiendaDTO;

@Entity
public class Tienda {

	@Id @GeneratedValue
    private int id;
    private double latitud;
    private double longitud;
    
    public Tienda(){}
    
    public Tienda(TiendaDTO tienda) {
    	this.latitud = tienda.getLatitud();
    	this.longitud = tienda.getLatitud();
	}
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
    
    
}