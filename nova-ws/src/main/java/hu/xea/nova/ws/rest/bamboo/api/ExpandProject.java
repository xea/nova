package hu.xea.nova.ws.rest.bamboo.api;

public enum ExpandProject {

	NONE("projects"),
	PROJECT("projects.project"),
	PLANS("projects.project.plans"),
	PLAN("projects.project.plans.plan"),
	ACTIONS("projects.project.plans.plan.actions");
	
	private final String expandType;
	
	ExpandProject(String value) {
		this.expandType = value;
	}
	
	@Override
	public String toString() {
		return expandType;
	}
}
