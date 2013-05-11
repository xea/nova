package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.api.Connection;
import hu.xea.nova.chat.api.Server;

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
		boolean connected = server != null;
		
		return connected;
	}

	@Override
	public boolean disconnect(String reason) {
		boolean disconnected = server.disconnect(this, reason);
		
		return disconnected;
	}

}
