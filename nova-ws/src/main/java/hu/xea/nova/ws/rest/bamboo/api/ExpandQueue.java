package hu.xea.nova.ws.rest.bamboo.api;

public enum ExpandQueue {

	NONE(""),
	QUEUED_BUILDS("queuedBuilds"),
	QUEUED_BUILDS_WITH_CHANGES("queuedBuilds.queuedBuild.changes");
	
	private String expandType;
	
	ExpandQueue(String expandType) {
		this.expandType = expandType;
	}
	
	@Override
	public String toString() {
		return expandType;
	}
}
