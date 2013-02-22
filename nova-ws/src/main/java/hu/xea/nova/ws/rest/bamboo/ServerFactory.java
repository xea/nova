package hu.xea.nova.ws.rest.bamboo;

import java.util.Arrays;
import java.util.List;

import hu.xea.nova.ws.rest.bamboo.api.AuthType;
import hu.xea.nova.ws.rest.bamboo.api.BambooServer;

/**
 * Allows clients to instantiate {@link BambooServer} instances without knowing
 * the implementation details.
 * 
 * @author xea
 */
public abstract class ServerFactory {
	
	/**
	 * Describes the properties of the Bamboo server connection
	 */
	protected BambooConnection connection;

	/**
	 * Returns an instance of {@link ServerFactory}.
	 * 
	 * At the first attempt it tries to instantiate a real Bamboo client and if
	 * it doesn't succeed then it creates a dummy client.
	 * 
	 * @return a {@link ServerFactory} instance
	 */
	public static ServerFactory getInstance(final BambooConnection connection) {
		final List<Class<? extends ServerFactory>> factoryClasses = getFactoryClasses();
		
		ServerFactory instance = null;

		for (final Class<? extends ServerFactory> factoryClass : factoryClasses) {
			if (instance == null) {
				instance = instantiateFactory(factoryClass, connection);
			} else {
				break;
			}
		}
		
		return instance;
	}

	/**
	 * Return a list of classes that can be used for instantiating a {@link BambooServer} object
	 * 
	 * @return possible {@link ServerFactory} classes
	 */
	protected static List<Class<? extends ServerFactory>> getFactoryClasses() {
		final List<Class<? extends ServerFactory>> factoryClasses = Arrays.asList(ResteasyServerFactory.class,
				MockServerFactory.class);

		return factoryClasses;
	}

	/**
	 * Attempts to instantiate an implementation-specific {@link ServerFactory} object based on the actual arguments
	 * 
	 * @param factoryClass the class of the new instance
	 * @param connection connection descriptor
	 * @return the newly instantiated {@link ServerFactory} or <code>null</code> if the instantiation failed
	 */
	protected static ServerFactory instantiateFactory(Class<? extends ServerFactory> factoryClass, final BambooConnection connection) {
		
		ServerFactory serverFactory = null;
		try {
			ServerFactory newServerFactory = factoryClass.newInstance();
			newServerFactory.setConnection(connection);
			
			if (newServerFactory.testConnection()) {
				serverFactory = newServerFactory;
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return serverFactory;
	}

	/**
	 * Retrieves an instance of the Bamboo Server REST API proxy.
	 * 
	 * @return a {@link BambooServer} object
	 */
	public abstract BambooServer getServer();
	
	/**
	 * Tests if the server specified by the connection descriptor (<code>connection</code>) is available
	 * @return <code>true</code> if the server is available, otherwise <code>false</code>
	 */
	public boolean testConnection() {
		final BambooServer server = getServer();
		
		boolean testSuccessful = false;
		
		try {
			server.authenticate(AuthType.BASIC.toString(), connection.getUsername(), connection.getPassword());
			
			testSuccessful = true;
		} catch (final Exception exception) {
			// if any exception occurs during the test then the connection is considered as faulty but we don't have
			// to handle the error, because this was only a test
		}
		
		return testSuccessful;
	}
	
	public void setConnection(final BambooConnection connection) {
		this.connection = connection;
	}
	
	public BambooConnection getConnection() {
		return connection;
	}
}
