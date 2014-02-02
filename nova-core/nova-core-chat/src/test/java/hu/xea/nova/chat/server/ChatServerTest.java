package hu.xea.nova.chat.server;

import static org.junit.Assert.*;
import hu.xea.nova.chat.Connection;
import hu.xea.nova.chat.ConnectionException;

import org.junit.Before;
import org.junit.Test;

public class ChatServerTest {

	private Server server;
	
	@Before
	public void setup() {
		server = new ChatServer();
	}
	
	@Test
	public void testIfInstantiable() {
		final Server server = new ChatServer();
		
		assertNotNull("A simple chat server always should be instantiable", server);
	}
	
	@Test
	public void testIfCanConnect() throws ConnectionException {
		final Connection connection = server.connect("user");
		
		assertNotNull("A server should never return null upon connection", connection);
	}

}
