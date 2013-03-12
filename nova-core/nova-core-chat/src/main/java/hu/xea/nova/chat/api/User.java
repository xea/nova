package hu.xea.nova.chat.api;

import java.util.List;
import java.util.Set;

public class User implements Client {
	
	private Long id;
	
	private String nickname;
	
	public User(final String nickname) {
		this.nickname = nickname;
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
		
	}

	@Override
	public List<Message> getMessageLog() {
		return null;
	}

}
