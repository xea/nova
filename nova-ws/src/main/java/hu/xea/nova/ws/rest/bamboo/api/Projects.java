package hu.xea.nova.ws.rest.bamboo.api;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A collection of Bamboo projects
 * 
 * @author xea
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "projects")
public class Projects {

	@XmlAttribute
	private String expand;
	
	@XmlElement
	private Projects projects;
	
	@XmlElement(name = "project")
	private Collection<Project> projectItems;
	
	/**
	 * Number of projects in the collection
	 */
	@XmlAttribute
	private int size;
	
	/**
	 * The maximum number of results returned
	 */
	@XmlAttribute(name = "max-result")
	private int maxResult;
	
	/**
	 * The index of the first element returned
	 */
	@XmlAttribute(name = "start-index")
	private int startIndex;

	public String getExpand() {
		return expand;
	}

	public void setExpand(String expand) {
		this.expand = expand;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public Collection<Project> getProjectItems() {
		return projectItems;
	}

	public void setProjectItems(Collection<Project> projectItems) {
		this.projectItems = projectItems;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
