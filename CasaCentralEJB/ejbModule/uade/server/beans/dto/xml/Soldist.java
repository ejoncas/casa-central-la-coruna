package uade.server.beans.dto.xml;

import java.util.ArrayList;
import java.util.List;

import uade.server.beans.dto.EnvioDTO;

public class Soldist {
	
	private Long numSolDist;
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

	public Long getNumSolDist() {
		return numSolDist;
	}

	public void setNumSolDist(Long numSolDist) {
		this.numSolDist = numSolDist;
	}
}
