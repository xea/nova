package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.AuthType;
import hu.xea.nova.ws.rest.bamboo.api.BambooServer;
import hu.xea.nova.ws.rest.bamboo.api.Projects;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class BambooClient {
	
	private BambooServer server;
	
	public void connect(final ServerFactory serverProvider) {
		server = serverProvider.getServer();
		// We are not going to provide credentials by default since the default 
		// test implementation uses a mock service
		server.authenticate(AuthType.Basic.toString(), "username", "password");
	}
	
	public Projects listProjects() {
		return server.listProjects();
	}
	
}
