package hu.xea.nova.ws.rest.bamboo.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public interface BambooServer {

	@GET
	@Path("/project")
	public void authenticate(@QueryParam("os_authType") String authType,
			@QueryParam("os_username") String username,
			@QueryParam("os_password") String password);
	
	/**
	 * Lists all the projects that are either marked as favourites or covered by Clover
	 * 
	 * @param expand expansion depth
	 * @param favourite filter to include only favourite projects
	 * @param cloverEnabled filter to include only Clover-covered projects
	 * @return the filtered project list
	 */
	@GET
	@Path("/project")
	public Projects listProjects(@QueryParam("expand") ExpandProject expand, 
			@QueryParam("favourite") Boolean favourite, 
			@QueryParam("cloverEnabled") Boolean cloverEnabled);
	
	/**
	 * Lists all the plans set up on the Bamboo server
	 * 
	 * @param expand expansion depth
	 * @param favourite include only favourite projects
	 * @param cloverEnabled include only Clover-enabled projects
	 * @return the filtered project list
	 */
	@GET
	@Path("/plan")
	public Plans listPlans(@QueryParam("expand") ExpandPlan expand, 
			@QueryParam("favourite") Boolean favourite, 
			@QueryParam("cloverEnabled") Boolean cloverEnabled);
	/**
	 * Lists the lates builds for all plans on the Bamboo server
	 * 
	 * @param expand expansion depth
	 * @param favourite include only favourite plans
	 * @param cloverEnabled include only Clover-enabled plans
	 * @param label include build results labelled with this label
	 * @param issueKey include build results which are related to this issue key
	 * @return the filtered build plan list
	 */
	@GET
	@Path("/result")
	public Results listResults(@QueryParam("expand") ExpandResult expand,
			@QueryParam("favourite") Boolean favourite,
			@QueryParam("cloverEnabled") Boolean cloverEnabled,
			@QueryParam("label") String label,
			@QueryParam("issueKey") String issueKey);
	
	/**
	 * Lists all the builds waiting in the build queue
	 * @param expand expansion depth
	 * @return the builds which are waiting in the build queue
	 */
	@GET
	@Path("/queue")
	public BuildQueue listProjectsInQueue(@QueryParam("expand") ExpandQueue expand);
	
	/**
	 * Adds a build to the build queue
	 * @param id the id of the plan to add to the queue 
	 */
	@POST
	@Path("/queue/{id}")
	public void queueBuild(@PathParam("id") String id);
	
	/**
	 * Removes a build from the build queue
	 * @param id the id of the plan to remove from the queue
	 */
	@DELETE
	@Path("/queue/{id}")
	public void unqueueBuild(@PathParam("id") String id);
}
