package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "change")
@XmlAccessorType(XmlAccessType.FIELD)
public class Change {

	@XmlAttribute
	private int changesetId;
	
	@XmlAttribute
	private String author;
	
}
