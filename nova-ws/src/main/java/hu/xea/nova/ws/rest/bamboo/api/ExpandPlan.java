package hu.xea.nova.ws.rest.bamboo.api;

public enum ExpandPlan {
	
	NONE("plans"),
	PLAN("plans.plan"),
	ACTIONS("plans.plan.actions");
	
	private final String expandType;
	
	ExpandPlan(String expandType) {
		this.expandType = expandType;
	}

	@Override
	public String toString() {
		return expandType;
	}
	
}
