package uade.server.beans.dto.xml;

import uade.server.beans.dto.ArticuloRopaDTO;


public class NuevoartRopa {

	private ArticuloRopaDTO ropa;
	
	public NuevoartRopa(){
		
	}
	public NuevoartRopa(ArticuloRopaDTO r){
		this.ropa = r;
	}
	public ArticuloRopaDTO getRopa() {
		return ropa;
	}
	public void setRopa(ArticuloRopaDTO ropa) {
		this.ropa = ropa;
	}
	
	
	
}
