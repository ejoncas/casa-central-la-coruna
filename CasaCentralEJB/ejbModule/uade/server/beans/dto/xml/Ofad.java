package uade.server.beans.dto.xml;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;

public class Ofad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6470058182955672580L;
	private Long id;
	private Set<ArticuloHogarDTO> accesoriosHogar;
	private Set<ArticuloRopaDTO> ropa;
	
	public Ofad(){
		accesoriosHogar = new HashSet<ArticuloHogarDTO>();
		ropa = new HashSet<ArticuloRopaDTO>();
	}
	
	public Set<ArticuloHogarDTO> getAccesoriosHogar() {
		return accesoriosHogar;
	}

	public void setAccesoriosHogar(Set<ArticuloHogarDTO> accesoriosHogar) {
		this.accesoriosHogar = accesoriosHogar;
	}

	public void setRopa(Set<ArticuloRopaDTO> ropa) {
		this.ropa = ropa;
	}
	public Set<ArticuloRopaDTO> getRopa() {
		return ropa;
	}

	public void addArticuloRopa(ArticuloRopaDTO r){
		if(this.ropa == null)
			this.ropa = new HashSet<ArticuloRopaDTO>();
		this.ropa.add(r);
	}
	public void addArticuloHogar(ArticuloHogarDTO h){
		if(this.accesoriosHogar ==null)
			this.accesoriosHogar = new HashSet<ArticuloHogarDTO>();
		this.accesoriosHogar.add(h);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
