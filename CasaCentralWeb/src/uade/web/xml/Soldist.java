package uade.web.xml;

import java.util.ArrayList;
import java.util.List;

import uade.server.beans.dto.EnvioDTO;

public class Soldist {
	
	public List<EnvioDTO> envios;
	
	public Soldist(){
		this.envios = new ArrayList<EnvioDTO>();
	}

	public List<EnvioDTO> getEnvios() {
		return envios;
	}

	public void setEnvios(List<EnvioDTO> envios) {
		this.envios = envios;
	}
	
	public void addEnvio(EnvioDTO e){
		this.envios.add(e);
	}
	
	

}
