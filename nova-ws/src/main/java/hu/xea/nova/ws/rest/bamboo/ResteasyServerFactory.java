package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.BambooServer;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * Provides instances of Resteasy client proxies for a remote Bamboo server
 * 
 * @author xea
 *
 */
public class ResteasyServerFactory extends ServerFactory {
	
	public static final String DEFAULT_SCHEME = "http";
	
	public static final String DEFAULT_HOST = "localhost";
	
	public static final String DEFAULT_PORT = "8085";
	
	public static final String DEFAULT_PATH = "/rest/api/latest";
	
	private String scheme = DEFAULT_SCHEME;
	
	private String host = DEFAULT_HOST;
	
	private String port = DEFAULT_PORT;
	
	private String path = DEFAULT_PATH;
	
	/**
	 * No-argument constructor that uses the default settings to determine
	 * where to look for the Bamboo server. 
	 * 
	 * Take a look at {@link ResteasyServerFactory#DEFAULT_HOST}, {@link ResteasyServerFactory#DEFAULT_PORT},
	 * {@link ResteasyServerFactory#DEFAULT_SCHEME} and {@link ResteasyServerFactory#DEFAULT_PATH}
	 * properties.
	 */
	public ResteasyServerFactory() {
		super();
	}
	
	/**
	 * Constructor that overrides the default host and port settings with the given arguments.
	 * 
	 * During connection these new values will be used.
	 * 
	 * @param host the hostname of the Bamboo server
	 * @param port the TCP port number where the Bamboo server is listening
	 */
	public ResteasyServerFactory(final String host, final String port) {
		this();
		this.host = host;
		this.port = port;
	}

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
