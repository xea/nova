package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.api.Channel;
import hu.xea.nova.chat.api.Server;
import hu.xea.nova.chat.api.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The default implementation of the {@link Server} interface.
 * 
 * @author xea
 *
 */
public class ChatServer implements Server {

	/**
	 * Indicates if the server should accept communication requests
	 */
	private boolean running = false;
	
	/**
	 * Stores the clients who are currently online
	 */
	private Map<String, User> clients = new ConcurrentHashMap<String, User>();
	
	/**
	 * Map of channels which are currently created. The user's nickname is used for key
	 */
	private Map<String, Channel> channels = new ConcurrentHashMap<String, Channel>();
	
	public boolean isStarted() {
		return running;
	}

	@Override
	public boolean start() {
		
		running = true;
		
		return running;
	}

	@Override
	public boolean stop() {
		
		running = false;
		
		return !running;
	}

	@Override
	public User connect(String nickname) {
		assert nickname != null : "null as nickname is not accepted";
		
		User newUser = null;
		
		if (nickname != null && isStarted() && !clients.containsKey(nickname)) {
			newUser = new User(nickname);
			clients.put(nickname, newUser);			
		}
		
		return newUser;
	}

	@Override
	public Channel join(String channelName, User user) {
		assert channelName != null : "null as channel name is not accepted";
		assert user != null : "null clients are not allowed to join";
		
		Channel joinedChannel = null;
		
		if (channelName != null && user != null && isStarted()) {
			if (!channels.containsKey(channelName)) {
				Channel newChannel = new PublicChannel(channelName);
				channels.put(channelName, newChannel);
				newChannel.join(user);
				
				joinedChannel = newChannel;
			}
		}
		
		return joinedChannel;
	}
}
