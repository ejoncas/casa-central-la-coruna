package uade.server.beans.dto.xml;

import java.util.ArrayList;
import java.util.List;

import uade.server.beans.dto.ArticuloHogarDTO;
import uade.server.beans.dto.ArticuloRopaDTO;

public class Ofad {
	
	private List<ArticuloHogarDTO> accesoriosHogar;
	private List<ArticuloRopaDTO> ropa;
	
	public Ofad(){
		accesoriosHogar = new ArrayList<ArticuloHogarDTO>();
		ropa = new ArrayList<ArticuloRopaDTO>();
	}
	public List<ArticuloHogarDTO> getAccesoriosHogar() {
		return accesoriosHogar;
	}
	public void setAccesoriosHogar(List<ArticuloHogarDTO> accesoriosHogar) {
		this.accesoriosHogar = accesoriosHogar;
	}
	public List<ArticuloRopaDTO> getRopa() {
		return ropa;
	}
	public void setRopa(List<ArticuloRopaDTO> ropa) {
		this.ropa = ropa;
	}
	
	public void addArticuloRopa(ArticuloRopaDTO r){
		this.ropa.add(r);
	}
	public void addArticuloHogar(ArticuloHogarDTO h){
		this.accesoriosHogar.add(h);
	}

}
