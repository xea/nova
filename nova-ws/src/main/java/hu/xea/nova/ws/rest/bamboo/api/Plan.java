package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plan {

	@XmlAttribute
	private Boolean enabled;
	
	@XmlAttribute
	private String type;
	
	@XmlAttribute
	private String shortKey;
	
	@XmlAttribute
	private String shortName;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String key;
	
	@XmlAttribute
	private String expand;
	
	@XmlElement
	private String projectKey;
	
	@XmlElement
	private String projectName;
	
	@XmlElement
	private Link link;
	
	@XmlElement
	private Boolean isFavourite;
	
	@XmlElement
	private Boolean isActive;
	
	@XmlElement
	private Boolean isBuilding;
	
	@XmlElement
	private Double averageBuildTimeInSeconds;
	
	@XmlElement
	private Actions actions;
	
}
