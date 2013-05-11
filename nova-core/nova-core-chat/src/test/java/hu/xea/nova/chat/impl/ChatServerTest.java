package hu.xea.nova.chat.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hu.xea.nova.chat.api.Connection;
import hu.xea.nova.chat.api.Server;

import org.junit.Before;
import org.junit.Test;

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
		
		final Connection connection = server.connect("testUser");
		assertNotNull("The server must allow connecting after starting", connection);
		assertTrue("A live connection must be returned after connecting", connection instanceof UserConnection);
		assertTrue("The connection must be updated after connecting", connection.isConnected());
	}
	
	@Test
	public void testIfConnectionIsCreatedWhenServerIsNotRunning() {
		final Connection connection = server.connect("testUser");
		assertNotNull("The server must handle connections when not running", connection);
		assertFalse("Offline connections must always show offline state", connection.isConnected());
	}
	
	@Test
	public void testIfCanDisconnect() {
		server.start();
		
		final Connection connection = server.connect("testUser");
		assertTrue("Connected users must be able to disconnect", connection.disconnect("test message"));
		assertFalse("Offline connections must not report online state", connection.isConnected());
	}
	
	@Test
	public void testIfCannotDisconnectMoreTimes() {
		server.start();
		final Connection connection = server.connect("testUser");
		connection.disconnect("test message");
		assertFalse("Offline connections must not allow disconnecting multiple times", connection.disconnect("test message"));
	}
	
	@Test
	public void testIfCannotConnectIfNotStarted() {
		final Connection connection = server.connect("testUser");
		assertFalse("Clients must not be able to connect if the server is not started", connection.isConnected());
	}
	
	@Test
	public void testIfCanConnectAfterRejoin() {
		server.start();
		server.stop();
		server.start();
		
		final Connection connection = server.connect("testUser");
		assertNotNull("Clients must be able to connect after the server is restarted", connection);
		assertTrue("Clients must be able to connect after the server is restarted", connection.isConnected());
	}
	
	@Test
	public void testIfNullNicknamesCannotJoin() {
		server.start();
		
		final Connection connection = server.connect(null);
		assertNotNull("Clients with null nicknames should receive a connection object too", connection);
		assertFalse("Clients with nicknames (null) must not be able to connect", connection.isConnected());
	}
}
