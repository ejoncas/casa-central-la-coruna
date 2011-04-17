package uade.is2.beans.xml;

import uade.is2.beans.ArticuloHogar;

public class NuevoartHogar {
	
	private ArticuloHogar accesorio;

	
	public NuevoartHogar(){
		
	}
	public NuevoartHogar(ArticuloHogar h){
		this.accesorio = h;
	}
	public ArticuloHogar getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(ArticuloHogar accesorio) {
		this.accesorio = accesorio;
	}
}
