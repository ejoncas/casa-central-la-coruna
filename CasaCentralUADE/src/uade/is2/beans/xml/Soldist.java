package uade.is2.beans.xml;

import java.util.ArrayList;
import java.util.List;

import uade.is2.beans.Envio;

public class Soldist {
	
	public List<Envio> envios;
	
	public Soldist(){
		this.envios = new ArrayList<Envio>();
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}
	
	public void addEnvio(Envio e){
		this.envios.add(e);
	}
	
	

}
