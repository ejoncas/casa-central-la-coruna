package uade.server.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Oferta {

	
	@Id @GeneratedValue
	private Long id;
	private Date fechaOferta;
	@ManyToMany
	private Set<Articulo> articulos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaOferta() {
		return fechaOferta;
	}
	public void setFechaOferta(Date fechaOferta) {
		this.fechaOferta = fechaOferta;
	}
	
	public void addArticulo(Articulo a){
		if(this.articulos==null)
			this.articulos = new HashSet<Articulo>();
		this.articulos.add(a);
	}
	public Set<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	

}
