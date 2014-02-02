package hu.xea.nova.chat;

/**
 * A connection between the server and a client. 
 * 
 * @author xea
 *
 */
public class UserConnection implements Connection {

	/**
	 * The display name of the user
	 */
	private String username;
	
	/**
	 * Creates a new UserConnection object, providing the username
	 * 
	 * @param username user name
	 */
	public UserConnection(final String username) {
		this.username = username;
	}
}
