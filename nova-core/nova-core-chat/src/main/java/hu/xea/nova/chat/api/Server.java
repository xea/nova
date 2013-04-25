package hu.xea.nova.chat.api;

/**
 * 
 * @author xea
 *
 */
public interface Server {

	
	/**
	 * Starts the server if it is not already started.
	 * 
	 * <p>When the server is started it can accept connection and communication 
	 * requests and processes them.</p>
	 * 
	 * <p>If the server was already running, then this method does nothing.</p>
	 * 
	 * @return <code>true</code> if the server was started successfully, otherwise <code>false</code>
	 */
	public boolean start();

	/**
	 * Stops the server if it was started before.
	 * 
	 * <p>If the server wasn't running then this method does nothing.</p>
	 * 
	 * @return <code>true</code> if the server was stopped successfully, otherwise <code>false</code>
	 */
	public boolean stop();
	
	/**
	 * Indicates if the server is running or not.
	 * 
	 * @return <code>true</code> if the server is running, otherwise <code>false</code>
	 */
	public boolean isStarted();
	
	/**
	 * Attempts to connect to the server with the supplied <code>nickname</code>.
	 * 
	 * <p>If the attempt was successful, then a newly created {@link User} object will be returned</p>
	 * 
	 * @param nickname the nickname to connect with
	 * @return the connected {@link User} object if successful, otherwise <code>null</code>
	 */
	public User connect(String nickname);
	
	/**
	 * Attempts to join the channel identified by <code>channelName</code>.
	 * 
	 * @param channelName the name of the channel to join
	 * @param user the user who is joining the channel
	 * @return the {@link Channel} object if successful, otherwise <code>null</code>
	 */
	public Channel join(String channelName, User user);
}
