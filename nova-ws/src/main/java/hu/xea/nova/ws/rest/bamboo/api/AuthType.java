package hu.xea.nova.ws.rest.bamboo.api;

/**
 * Felsorolja a Bamboo REST API-ján használható authentikációs eljárástípusokat
 * 
 * @author sandor.pecsi
 *
 */
public enum AuthType {

	Basic("basic");
	
	private final String type;
	
	AuthType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}
	
}
