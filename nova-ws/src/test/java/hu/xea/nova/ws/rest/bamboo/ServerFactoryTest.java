package hu.xea.nova.ws.rest.bamboo;

import org.junit.Assert;
import org.junit.Test;

public class ServerFactoryTest {

	@Test
	public void testIfInstantiates() {
		final BambooConnection connection = new BambooConnection("localhost", "test", "test");
		final ServerFactory factory = ServerFactory.getInstance(connection);
		
		Assert.assertNotNull("The ServerFactory must always return a valid object", factory);
	}
}
