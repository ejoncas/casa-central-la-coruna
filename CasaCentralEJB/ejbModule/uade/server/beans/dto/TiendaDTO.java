package uade.server.beans.dto;

import java.io.Serializable;

public class TiendaDTO  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4826670371298380655L;
	private int id;
    private float latitud;
    private float longitud;
    
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public float getLatitud() {
            return latitud;
    }
    public void setLatitud(float latitud) {
            this.latitud = latitud;
    }
    public float getLongitud() {
            return longitud;
    }
    public void setLongitud(float longitud) {
            this.longitud = longitud;
    }
    
    
}