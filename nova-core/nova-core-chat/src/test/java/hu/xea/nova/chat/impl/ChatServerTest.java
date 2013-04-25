package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.api.Server;
import hu.xea.nova.chat.api.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ChatServerTest {
	
	private Server server;
	
	@Before
	public void setup() {
		server = new ChatServer();
	}
	
	@Test
	public void testIfCanInitialize() {
		assertNotNull("The Chat Server object must be instantiatable", server);
	}

	@Test
	public void testIfCanStartServer() {
		assertFalse("The Chat Server must be in stopped state after initialization", server.isStarted());
		
		server.start();
		assertTrue("The Chat Server must be in started state after a successful start", server.isStarted());
	}
	
	@Test
	public void testIfCanStopServer() {
		server.start();
		
		server.stop();
		assertFalse("The Chat Server must be in stopped state after a successful stop", server.isStarted());
	}
	
	@Test
	public void testIfCanConnect() {
		server.start();
		
		final User user = server.connect("testUser");
		assertNotNull("The server must allow connecting after starting", user);
	}
	
	@Test
	public void testIfCannotConnectIfNotStarted() {
		assertNull("Clients must not be able to connect if the server is not started", server.connect("testUser"));
	}
	
	@Test
	public void testIfCanConnectAfterRejoin() {
		server.start();
		server.stop();
		server.start();
		
		assertNotNull("Clients must be able to connect after the server is restarted", server.connect("testUser"));
	}
	
	@Test
	public void testIfNullNicknamesCannotJoin() {
		server.start();
		
		assertNull("Clients with nicknames (null) must not be able to join", server.connect(null));
	}
}
