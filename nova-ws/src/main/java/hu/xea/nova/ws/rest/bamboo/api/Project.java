package hu.xea.nova.ws.rest.bamboo.api;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Descriptor of a Bamboo project
 * 
 * @author xea 
 *
 */
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String key;
	
	@XmlElement(name = "link")
	private Link link;
	
	/**
	 * The plans contained by this project
	 */
	@XmlElement(name = "plans")
	private Plans plans;
}
