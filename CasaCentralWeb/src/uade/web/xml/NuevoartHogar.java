package uade.web.xml;

import uade.server.beans.dto.ArticuloHogarDTO;

public class NuevoartHogar {
	
	private ArticuloHogarDTO accesorio;

	
	public NuevoartHogar(){
		
	}
	public NuevoartHogar(ArticuloHogarDTO a) {
		accesorio = a;
	}
	public ArticuloHogarDTO getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(ArticuloHogarDTO accesorio) {
		this.accesorio = accesorio;
	}
}
