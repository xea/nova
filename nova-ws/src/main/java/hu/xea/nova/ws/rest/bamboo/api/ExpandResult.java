package hu.xea.nova.ws.rest.bamboo.api;

public enum ExpandResult {
	
	NONE("results"),
	RESULT("results.result"),
	LATEST("results[0].result"),
	LATEST3("results[0:3].result"),
	LATEST10("results[0:10].result"),
	ARTIFACT("results.result.artifacts"),
	LABEL("results.result.labels"),
	COMMENT("results.result.comments"),
	JIRA_ISSUES("results.result.jiraIssues");

	private final String expandType;
	
	ExpandResult(String expandType) {
		this.expandType = expandType;
	}
}
