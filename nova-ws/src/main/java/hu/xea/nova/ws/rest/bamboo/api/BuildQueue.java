package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "queue")
@XmlAccessorType(XmlAccessType.FIELD)
public class BuildQueue {

	@XmlElement(name = "queuedBuilds")
	private QueuedBuilds queuedBuilds;
	
}
