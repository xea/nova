package hu.xea.nova.ws.rest.bamboo;

import hu.xea.nova.ws.rest.bamboo.api.Projects;
import hu.xea.nova.ws.rest.bamboo.api.Results;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BambooTest {
	
	private BambooClient client;
	
	@Before
	public void setup() {
		final BambooConnection connection = new BambooConnection("localhost", "xea", "test");
		final ServerFactory factory = ServerFactory.getInstance(connection);
		client = new BambooClient(factory);
	}

	@Test
	public void testListProjects() {
		/*client.connect();
		Projects projects = client.listProjects();
		
		assertNotNull("The projects object should not be null after a successful connection", projects);*/
	}
	
}
