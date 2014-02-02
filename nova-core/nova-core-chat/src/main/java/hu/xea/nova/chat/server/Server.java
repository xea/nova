package hu.xea.nova.chat.server;

import hu.xea.nova.chat.Connection;
import hu.xea.nova.chat.ConnectionException;

/**
 * Plays a central role in the application as allowing the clients to communicate with each other and
 * provides the infrastructure to keep the clients connected.
 * 
 * @author xea
 *
 */
public interface Server {

	/**
	 * Attempts to connect to the server.
	 * 
	 * <p>After a connection is established, the client may use the server's resources to communicate
	 * with other clients</p>
	 * 
	 * @param username the desired username
	 * @return the established connection
	 * @throws ConnectionException if the connection can not be established
	 */
	Connection connect(String username) throws ConnectionException;
	
}
