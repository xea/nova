package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.AuthType;
import hu.xea.nova.ws.rest.bamboo.api.BambooServer;
import hu.xea.nova.ws.rest.bamboo.api.ExpandProject;
import hu.xea.nova.ws.rest.bamboo.api.Projects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bamboo connection client that utilizes the Bamboo Server's REST API for
 * communication
 * 
 * It hides the implementation details of the REST API and provides an
 * easy-to-use interface for 3rd party usage
 * 
 * @author xea
 * 
 */
public class BambooClient {

	private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

	/**
	 * The Bamboo Server REST API impelementation
	 */
	private BambooServer server;

	/**
	 * Connection descriptor for the Bamboo Server
	 */
	private BambooConnection connection;

	/**
	 * Constructs a new {@link BambooClient} object which will use the specified
	 * factory object to establish the actual connection
	 * 
	 * @param serverFactory
	 *            factory to generate the actual connection
	 */
	public BambooClient(final ServerFactory serverFactory) {
		server = serverFactory.getServer();
		connection = serverFactory.getConnection();
	}

	/**
	 * Initializes the connection between the Bamboo client and the server using
	 * the previously set connection details
	 */
	public void connect() {
		logger.info("Establishing connection to Bamboo server at {}", connection.toString());
		server.authenticate(AuthType.BASIC.toString(), connection.getUsername(), connection.getPassword());
	}

	/**
	 * Lists the available Bamboo projects
	 * @return projects collection
	 */
	public Projects listProjects() {
		final Projects projects = server.listProjects(ExpandProject.ACTIONS, null, null);

		logger.info("{} projects retreived", projects.getProjects().getSize());

		return projects.getProjects();
	}

	public Projects listProjects(final boolean favourites, final boolean cloverEnabled) {
		final Projects projects = server.listProjects(ExpandProject.ACTIONS, favourites, cloverEnabled);

		logger.info("{} projects retreived", projects.getProjects().getSize());

		return projects.getProjects();
	}

}
