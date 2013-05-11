package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.api.Channel;
import hu.xea.nova.chat.api.Server;
import hu.xea.nova.chat.api.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ChatServerChannelTest {

	private Server server;
	
	@Before
	public void setup() {
		server = new ChatServer();
		
	}
	
	/*
	@Test
	public void testIfUsersCanJoinChannel() {
		server.start();
		final User user = server.connect("testUser");
		final Channel channel = server.join("testChannel", user);
		
		assertNotNull("Users must be able to join channels when the server is running", channel);
		assertTrue("Joined users must be able to looked up from the joined channels", channel.hasUser("testUser"));
	}
	
	@Test
	public void testIfUsersCanJoinExistingChannels() {
		server.start();
		final User user = server.connect("testUser");
		final Channel channel = server.join("testChannel", user);
		assertNotNull("The first join should always be successful", channel);
		assertNull("Joining a channel more times should not result in multiple connections", server.join("testChannel", user));
	}
	
	@Test
	public void testIfUsersCanPartChannel() {
		server.start();
		final User user = server.connect("testUser");
		final Channel channel = server.join("testChannel",  user);
		assertTrue("Users must be able to leave channels", server.part(channel, user));
	}*/
}
