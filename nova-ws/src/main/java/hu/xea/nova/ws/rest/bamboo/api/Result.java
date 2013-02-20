package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {

	@XmlAttribute
	private int number;
	
	@XmlAttribute
	private String state;
	
	@XmlAttribute
	private String key;
	
	@XmlAttribute
	private String restartable;
	
	@XmlAttribute
	private String continuable;
	
}
