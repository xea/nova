package hu.xea.nova.chat.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import hu.xea.nova.chat.api.Connection;
import hu.xea.nova.chat.api.Server;

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
	 * Stores the next assignable connectionId
	 */
	private volatile int nextConnectionId = 1;
	
	/**
	 * Holds references of the connection objects assigned to nick names
	 */
	private Map<String, Connection> connections = new ConcurrentHashMap<String, Connection>();
	
	@Override
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
	public Connection connect(String nickname) {
		Connection connection = null;
		
		if (mayConnect(nickname)) {
			connection = new UserConnection(this);
			connections.put(nickname, connection);
		} else {
			connection = new OfflineConnection();
		}
		
		return connection;
	}
	
	/**
	 * Returns the next assignable connection identifier 
	 * @return connection ID
	 */
	protected synchronized int generateConnectionID() {
		return ++nextConnectionId;
	}
	
	/**
	 * Indicates if there is an online user with the specified nickname
	 * 
	 * @param nickname nickname
	 * @return <code>true</code> if the given nickname already exists, otherwise <code>false</code>
	 */
	protected boolean hasUser(final String nickname) {
		return false;
	}

	/**
	 * Determines if a user with the given nickname may connect to the server or not.
	 * 
 	 * @param nickname nickname
	 * @return <code>true</code> if the given user can connect, otherwise <code>false</code>
	 */
	protected boolean mayConnect(final String nickname) {
		boolean mayConnect = isStarted() && nickname != null && !hasUser(nickname);
		
		return mayConnect;
	}
}
