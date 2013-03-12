package hu.xea.nova.chat.api;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * A channel that can be accessed by every user
 * 
 * @author xea
 *
 */
public class PublicChannel implements Channel {

	private String name;
	
	private List<Message> messages = new CopyOnWriteArrayList<Message>();
	
	private Set<User> users = new CopyOnWriteArraySet<User>();
	
	/**
	 * No-argument constructor for empty initialization
	 */
	public PublicChannel() {
		super();
	}
	
	/**
	 * Constructor that sets the initial channelName
	 * @param channelName name of the channel
	 */
	public PublicChannel(final String channelName) {
		this();
		this.name = channelName;
	}
	
	@Override
	public void kick(final User user, final String reason) {
		assert user != null : "User should not be null";
		
		if (hasUser(user.getNickname())) {
			final Message kickMessage = new Message("You were kicked from channel " + name + " by " + user.getNickname() + "; reason: " + reason);
		
			users.remove(user);
			user.receive(kickMessage);
		}
		
		assert !users.contains(user) : "User should not be present after kicking";
	}

	@Override
	public void invite(final User user) {
		assert user != null : "User should not be null";
		
		final Message invitation = new Message("You were invited to channel " + name);
		
		user.receive(invitation);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void broadcast(final Message message) {
		assert message != null : "Message should not be null";
		
		messages.add(message);
		
		for (final User user : users) {
			user.receive(message);
		}
	}

	@Override
	public boolean hasUser(final String nickname) {
		assert nickname != null : "Null nicknames are forbidden";
		
		boolean result = false;
		
		for (final User user : users) {
			if (nickname.equals(user.getNickname())) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void join(final User user) {
		assert user != null;
		
		if (!hasUser(user.getNickname())) {
			final Message message = new Message(user.getNickname() + " has joined the channel");
			
			users.add(user);
			broadcast(message);
		}
	}

	@Override
	public void receive(Message message) {
		broadcast(message);
	}

	@Override
	public List<Message> getMessageLog() {
		return messages;
	}

	@Override
	public String toString() {
		return "Channel {" + name + "} with " + users.size() + " user(s) and " + messages.size() + " message(s)";
	}
}
