package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.Channel;
import hu.xea.nova.chat.Connection;
import hu.xea.nova.chat.Server;
import hu.xea.nova.chat.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ChatServerChannelTest {

	private Server server;
	
	@Before
	public void setup() {
		server = new ChatServer();
	}
	
	@Test
	public void testIfUsersCanJoinChannel() {
		server.start();
		
		final Connection connection = server.connect("testUser");
		final Channel channel = connection.join("testChannel");
		
		assertNotNull("Users must be able to join channels", channel);
		assertEquals("The joining user must be visible in the joined list of the channel", channel.hasUser("testUser"));
	}
	
	@Test
	public void testIfUsersCanPartChannel() {
		fail();
	}
	
	@Test
	public void testIfUsersCannotJoinMultipleTimes() {
		fail();
	}
	
	@Test
	public void testIfUsersCanRejoinAfterPart() {
		fail();
	}
	
	@Test
	public void testIfUsersCanLeavePartMessage() {
		fail();
	}
}
