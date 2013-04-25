package hu.xea.nova.chat.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hu.xea.nova.chat.api.Channel;
import hu.xea.nova.chat.api.User;
import hu.xea.nova.chat.impl.PublicChannel;

import org.junit.Test;

/**
 * Tests if the {@link PublicChannel} class impelements the {@link Channel}
 * interface properly. 
 * 
 * This implementation should act as a public guesthouse where anybody can
 * potentially enter or leave.
 * 
 * @author xea
 *
 */
public class PublicChannelTest {

	@Test
	public void testIfInstantiable() {
		final PublicChannel channel = new PublicChannel();
		assertNotNull(channel);
	}
	
	@Test
	public void testIfCanAssignName() {
		final String channelName = "main";
		final PublicChannel channel = new PublicChannel(channelName);
		assertNotNull(channel);
		assertEquals(channelName, channel.getName());
	}
	
	@Test
	public void testIfCanJoin() {
		final User user = new User("testUser");
		final Channel channel = new PublicChannel("main");
		channel.join(user);
		
		assertTrue(channel.hasUser("testUser"));
	}
	
	@Test
	public void testIfCanKick() {
		final User user = new User("testUser");
		final Channel channel = new PublicChannel("main");
		channel.join(user);
		
		channel.kick(user, "Test reason");
		assertFalse(channel.hasUser("testUser"));
	}
	
	@Test
	public void testIfCanInvite() {
		final User user = new User("testUser");
		final Channel channel = new PublicChannel("main");
		
		channel.invite(user);
		
		assertFalse(channel.hasUser("testUser"));
	}
	
	@Test
	public void testHasUser() {
		final User user = new User("testUser");
		final Channel channel = new PublicChannel("main");
		
		assertFalse(channel.hasUser("testUser"));
		channel.join(user);
		assertTrue(channel.hasUser("testUser"));
	}
}
