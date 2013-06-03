package hu.xea.nova.chat;

/**
 * A single client-to-server connection which allows the use of every
 * fundamental service of the chat service 
 * 
 * @author xea
 *
 */
public interface Connection {

	/**
	 * Indicates if this is a live connection or not
	 * @return <code>true</code> if the connection is alive, otherwise <code>false</code>
	 */
	public boolean isConnected();
	
	/**
	 * Disconnects from the server telling it the specified reason.
	 * 
	 * @param reason the reason of disconnecting
	 * @return <code>true</code> if disconnecting was successful otherwise <code>false</code>
	 */
	public boolean disconnect(String reason);
	
	/**
	 * Attempts to join the specified channel.
	 * 
	 * @param channelName name of the channel to join
	 * @return the joined <code>Channel</code> or <code>null</code> if the user is not allowed to join
	 */
	public Channel join(String channelName);
}