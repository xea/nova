package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "projects")
public class Projects {

	@XmlAttribute
	private String expand;
	
	@XmlAttribute
	private Projects projects;
	
	private int size;
	
	@XmlAttribute(name = "max-result")
	private int maxResult;
	
	@XmlAttribute(name = "start-index")
	private int startIndex;

}
