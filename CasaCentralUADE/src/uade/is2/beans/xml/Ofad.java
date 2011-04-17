package uade.is2.beans.xml;

import java.util.ArrayList;
import java.util.List;

import uade.is2.beans.ArticuloHogar;
import uade.is2.beans.ArticuloRopa;

public class Ofad {
	
	private List<ArticuloHogar> accesoriosHogar;
	private List<ArticuloRopa> ropa;
	
	public Ofad(){
		accesoriosHogar = new ArrayList<ArticuloHogar>();
		ropa = new ArrayList<ArticuloRopa>();
	}
	public List<ArticuloHogar> getAccesoriosHogar() {
		return accesoriosHogar;
	}
	public void setAccesoriosHogar(List<ArticuloHogar> accesoriosHogar) {
		this.accesoriosHogar = accesoriosHogar;
	}
	public List<ArticuloRopa> getRopa() {
		return ropa;
	}
	public void setRopa(List<ArticuloRopa> ropa) {
		this.ropa = ropa;
	}
	
	public void addArticuloRopa(ArticuloRopa r){
		this.ropa.add(r);
	}
	public void addArticuloHogar(ArticuloHogar h){
		this.accesoriosHogar.add(h);
	}

}
