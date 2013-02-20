package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.AuthType;
import hu.xea.nova.ws.rest.bamboo.api.BambooServer;
import hu.xea.nova.ws.rest.bamboo.api.ExpandProject;
import hu.xea.nova.ws.rest.bamboo.api.Projects;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BambooClient {
	
	private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
	
	private BambooServer server;
	
	public BambooClient(final ServerFactory serverProvider) {
		server = serverProvider.getServer();
		logger.info("----\"----");
		logger.error("asdfasdf", new Exception("adsfasd"));
	}
	
	public void connect(final String username, final String password) {
		server.authenticate(AuthType.BASIC.toString(), username, password);
	}
	
	public Projects listProjects() {
		final Projects projects = server.listProjects(ExpandProject.ACTIONS, null, null);
		
		logger.info("{} projects retreived", projects.getProjects().getSize());
		
		return projects.getProjects();
	}
	
	public Projects listProjects(final boolean favourites, final boolean cloverEnabled) {
		final Projects projects =  server.listProjects(ExpandProject.ACTIONS, favourites, cloverEnabled);
		
		logger.info("{} projects retreived", projects.getProjects().getSize());
		
		return projects.getProjects();
	}
	
}
