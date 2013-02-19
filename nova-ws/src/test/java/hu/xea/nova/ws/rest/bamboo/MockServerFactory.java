package hu.xea.nova.ws.rest.bamboo;

import org.mockito.Mockito;

import hu.xea.nova.ws.rest.bamboo.api.BambooServer;

public class MockServerFactory extends ServerFactory {

	@Override
	public BambooServer getServer() {
		return Mockito.mock(BambooServer.class);
	}

}
