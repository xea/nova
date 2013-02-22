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
	
	/**
	 * Connection descriptor of the Bamboo Server
	 */
	private BambooConnection connection;
	
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
		this.connection = new BambooConnection();
	}
	
	/**
	 * Constructor that overrides the default host and port settings with the given arguments.
	 * 
	 * During connection these new values will be used.
	 * 
	 * @param connection the connection descriptor used to connect
	 */
	public ResteasyServerFactory(final BambooConnection connection) {
		this();
		this.connection = connection;
	}

	@Override
	public BambooServer getServer() {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		
		final String URL = connection.toString();
		final BambooServer server = ProxyFactory.create(BambooServer.class, URL);
		
		return server;
	}
}
