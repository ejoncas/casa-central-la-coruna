
package uade.server.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CentroDistribucion {

	@Id @GeneratedValue
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
