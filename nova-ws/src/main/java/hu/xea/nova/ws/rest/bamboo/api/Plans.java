package hu.xea.nova.ws.rest.bamboo.api;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plans")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plans {

	@XmlAttribute
	private String expand;
	
	@XmlAttribute
	private int size;
	
	@XmlAttribute(name = "max-result")
	private int maxResult;
	
	@XmlAttribute(name = "start-index")
	private int startIndex;
	
	@XmlElement(name = "plan")
	private Collection<Plan> plans;
	
}
