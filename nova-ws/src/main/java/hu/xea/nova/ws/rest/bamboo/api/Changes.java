package hu.xea.nova.ws.rest.bamboo.api;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "changes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Changes {
	
	@XmlAttribute
	private int size;
	
	@XmlAttribute
	private int maxResult;
	
	@XmlAttribute
	private int startIndex;

	@XmlElement(name = "change")
	private Collection<Change> changes;
}
