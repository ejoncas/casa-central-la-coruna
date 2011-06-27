package uade.server.beans;

import java.util.Date;
import java.util.List;

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
	private List<Articulo> articulos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	public Date getFechaOferta() {
		return fechaOferta;
	}
	public void setFechaOferta(Date fechaOferta) {
		this.fechaOferta = fechaOferta;
	}
	
	
	
	

}
