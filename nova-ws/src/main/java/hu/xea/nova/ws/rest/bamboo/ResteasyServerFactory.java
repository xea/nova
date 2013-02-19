package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.BambooServer;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class ResteasyServerFactory extends ServerFactory {
	
	public static final String DEFAULT_SCHEME = "http";
	
	public static final String DEFAULT_HOST = "localhost";
	
	public static final String DEFAULT_PORT = "8085";
	
	public static final String DEFAULT_PATH = "/rest/api/latest";
	
	private String scheme = DEFAULT_SCHEME;
	
	private String host = DEFAULT_HOST;
	
	private String port = DEFAULT_PORT;
	
	private String path = DEFAULT_PATH;

	@Override
	public BambooServer getServer() {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		
		final String URL = getConnectionString();
		final BambooServer server = ProxyFactory.create(BambooServer.class, URL);
		
		return server;
	}
	
	protected String getConnectionString() {
		return scheme + "://" + host + ":" + port + path;
	}
}
