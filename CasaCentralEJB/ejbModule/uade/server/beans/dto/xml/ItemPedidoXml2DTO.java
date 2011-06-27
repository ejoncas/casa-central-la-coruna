package uade.server.beans.dto.xml;

import java.io.Serializable;

public class ItemPedidoXml2DTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222443063167287864L;
	private String ref;
	private Integer cant;
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Integer getCant() {
		return cant;
	}
	public void setCant(Integer cant) {
		this.cant = cant;
	}
	
}
