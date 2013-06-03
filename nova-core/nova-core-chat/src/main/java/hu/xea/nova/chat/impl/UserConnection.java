package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.Channel;
import hu.xea.nova.chat.Connection;
import hu.xea.nova.chat.Server;

/**
 * A simple connection between a regular human user and the server
 * 
 * @author xea 
 *
 */
public class UserConnection implements Connection {
	
	/** 
	 * Reference to the Server object
	 */
	private Server server;
	
	public UserConnection(final Server server) {
		this.server = server;
	}

	@Override
	public boolean isConnected() {
		boolean connected = false;
		
		if (server != null && server.isConnected(this)) {
			connected = true;
		}
		
		return connected;
	}

	@Override
	public boolean disconnect(String reason) {
		boolean disconnected = server.disconnect(this, reason);
		
		return disconnected;
	}

	@Override
	public Channel join(String channelName) {
		
		final Channel channel = server.joinChannel(this, channelName);
		
		return null;
	}

}
