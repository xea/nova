package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "queuedBuild")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueuedBuild {

	@XmlAttribute
	private String buildResultKey;
	
	@XmlAttribute
	private int buildNumber;
	
	@XmlAttribute
	private String planKey;
	
	@XmlElement
	private String triggerReason;
	
	@XmlElement
	private Changes changes;
}
