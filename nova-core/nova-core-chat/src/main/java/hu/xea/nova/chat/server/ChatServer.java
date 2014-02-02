package hu.xea.nova.chat.server;

import hu.xea.nova.chat.Connection;
import hu.xea.nova.chat.ConnectionException;
import hu.xea.nova.chat.UserConnection;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * An in-memory implementation of the {@link Server} interface.
 * 
 * @author xea
 *
 */
public class ChatServer implements Server {
	
	private Set<Connection> connections = new CopyOnWriteArraySet<Connection>();
	
	

	@Override
	public Connection connect(String username) throws ConnectionException {
		
		final Connection connection = new UserConnection(username);
		
		connections.add(connection);
		
		return connection;
	}

	protected boolean hasUser(final String username) {
		assert username != null : "Username should not be null";
		
		
		return false;
	}
	
}
