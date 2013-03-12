package hu.xea.nova.chat.api;

import java.util.Set;

public interface Client extends MessageTarget {

	public static final String DEFAULT_MESSAGE = "valami";
	
	public Long getId();
	
	public String getNickname();
	
	public Set<Channel> getJoinedChannels();
	
}
