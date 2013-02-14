package hu.xea.nova.ws.rest.bamboo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

public interface BambooServer {

	@GET
	@Path("/project")
	public void authenticate(@QueryParam("os_authType") String authType,
			@QueryParam("os_username") String username,
			@QueryParam("os_password") String password);
	
	@GET
	@Path("/project")
	public Projects listProjects();

}
