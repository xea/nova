package hu.xea.nova.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A generic, human chat client who is able to use the provided services of the server.
 * 
 * Most clients will be represented by this object.
 * 
 * @author xea
 *
 */
public class User implements Client {
	
	/**
	 * The unique client id
	 */
	private Long id;
	
	/**
	 * Nickname of this client
	 */
	private String nickname;
	
	/**
	 * Messages list
	 */
	private List<Message> messages;
	
	/**
	 * Constructs a new User using the specified nickname
	 * @param nickname nickname
	 */
	public User(final String nickname) {
		assert nickname != null : "nickname is not supposed to be null";
		
		this.nickname = nickname;
		this.messages = new ArrayList<Message>();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNickname() {
		return nickname;
	}

	@Override
	public Set<Channel> getJoinedChannels() {
		return null;
	}

	@Override
	public void receive(Message message) {
		assert message != null : "null message received";
		
		messages.add(message);
	}

	@Override
	public List<Message> getMessageLog() {
		return null;
	}
	
	@Override
	public boolean isConnected() {
		return false;
	}

}
