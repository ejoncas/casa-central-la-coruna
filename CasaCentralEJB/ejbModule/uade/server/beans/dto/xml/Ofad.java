package uade.server.beans.dto.xml;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import uade.server.beans.dto.ArticuloHogarOfadDTO;
import uade.server.beans.dto.ArticuloRopaOfadDTO;

public class Ofad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6470058182955672580L;
	private Long id;
	
	private Set<ArticuloRopaOfadDTO> ropa;
	private Set<ArticuloHogarOfadDTO> accesoriosHogar;
	
	public Ofad(){
		accesoriosHogar = new HashSet<ArticuloHogarOfadDTO>();
		ropa = new HashSet<ArticuloRopaOfadDTO>();
	}
	

	public Set<ArticuloHogarOfadDTO> getAccesoriosHogar() {
		return accesoriosHogar;
	}


	public void setAccesoriosHogar(Set<ArticuloHogarOfadDTO> accesoriosHogar) {
		this.accesoriosHogar = accesoriosHogar;
	}


	public Set<ArticuloRopaOfadDTO> getRopa() {
		return ropa;
	}


	public void setRopa(Set<ArticuloRopaOfadDTO> ropa) {
		this.ropa = ropa;
	}


	public void addArticuloRopa(ArticuloRopaOfadDTO r){
		if(this.ropa == null)
			this.ropa = new HashSet<ArticuloRopaOfadDTO>();
		this.ropa.add(r);
	}
	public void addArticuloHogar(ArticuloHogarOfadDTO h){
		if(this.accesoriosHogar ==null)
			this.accesoriosHogar = new HashSet<ArticuloHogarOfadDTO>();
		this.accesoriosHogar.add(h);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
