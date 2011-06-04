package uade.web.exception;

public class WebApplicationException extends Exception{

	public WebApplicationException(Exception e, String desc) {
			super(desc,e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -776861477401433173L;
	
	

}
