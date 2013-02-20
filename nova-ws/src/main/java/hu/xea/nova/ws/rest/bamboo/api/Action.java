package hu.xea.nova.ws.rest.bamboo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "action")
@XmlAccessorType(XmlAccessType.FIELD)
public class Action {
	
	@XmlElement
	private Name name;
	
	@XmlType(name = "name")
	@XmlEnum
	public enum Name {

		@XmlEnumValue("READ")
		READ("READ"),
	
		@XmlEnumValue("WRITE")
		WRITE("WRITE"),
	
		CREATE("CREATE"),
	
		DELETE("DELETE"),
	
		BUILD("BUILD"),
	
		CLONE("CLONE"),
	
		ADMINSTRATION("ADMINISTRATION");
	
		String name;
	
		Name(String name) {
			this.name = name;
		}
	}
}
