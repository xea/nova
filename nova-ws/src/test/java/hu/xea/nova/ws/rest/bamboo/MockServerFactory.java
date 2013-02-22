package hu.xea.nova.ws.rest.bamboo;

import org.mockito.Mockito;

import hu.xea.nova.ws.rest.bamboo.api.BambooServer;

/**
 * Provides mock {@link ServerFactory} classes for testing purposes
 *  
 * @author xea
 *
 */
public class MockServerFactory extends ServerFactory {

	@Override
	public BambooServer getServer() {
		return Mockito.mock(BambooServer.class);
	}

}
