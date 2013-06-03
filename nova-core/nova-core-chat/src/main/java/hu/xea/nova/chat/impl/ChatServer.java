package hu.xea.nova.chat.impl;

import hu.xea.nova.chat.Connection;
import hu.xea.nova.chat.Server;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

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
	 * Holds references of the connection objects
	 */
	private Set<Connection> connections = new CopyOnWriteArraySet<Connection>();
	
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
			connections.add(connection);
		} else {
			connection = new OfflineConnection();
		}
		
		return connection;
	}
	
	@Override
	public boolean disconnect(Connection connection, String reason) {
		boolean disconnected = false;
		
		if (connection instanceof UserConnection && connections.contains(connection)) {
			connections.remove(connection);
			
			disconnected = true;
		}
		
		return disconnected;
	}
	
	@Override
	public boolean isConnected(Connection connection) {
		boolean connected = false;
		
		if (connection != null && connections.contains(connection)) {
			connected = true;
		}
		
		return connected;
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
