package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

	/**
	 * Relationship between link and element (defaults to "self")
	 */
	@XmlAttribute
	private String rel;
	
	/**
	 * URL for the project
	 */
	@XmlAttribute
	private String href;
}
