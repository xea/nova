package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.AuthType;
import hu.xea.nova.ws.rest.bamboo.api.BambooServer;
import hu.xea.nova.ws.rest.bamboo.api.Projects;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class BambooClient {
	
	private BambooServer server;

	public void connect() {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		
		final String scheme = "http";
		final String host = "192.168.12.16";
		final String port = "8085";
		//final String path = "/bamboo/rest/api/latest";
		final String path = "/rest/api/latest";
		
		final String URL = scheme + "://" + host + ":" + port + path;
		
		server = ProxyFactory.create(BambooServer.class, URL);
		
		server.authenticate(AuthType.Basic.toString(), "sandor.pecsi@shiwaforce.com", "JAkVGN[J6muQBMNr");
	}
	
	public Projects listProjects() {
		return server.listProjects();
	}
	
}
