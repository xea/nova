package hu.xea.nova.chat.api;

import java.util.Set;

/**
 * Describes a generic Chat client that can connect to the Server.
 * 
 * This abstraction allows the creation of non-human clients like 
 * services.
 * 
 * @author xea
 *
 */
public interface Client extends MessageTarget {

	public static final String DEFAULT_MESSAGE = "";
	
	/**
	 * Returns the unique identifier of this client
	 * 
	 * @return unique ID
	 */
	public Long getId();
	
	/**
	 * Returns the name as this client appears on the clients list
	 * 
	 * @return clients name
	 */
	public String getNickname();
	
	/**
	 * Returns a set of channels where this client is joined at the moment.
	 * 
	 * @return set of joined channels
	 */
	public Set<Channel> getJoinedChannels();
	
	/**
	 * Indicates if the client is currently connected to the server or not
	 * 
	 * @return <code>true</code> if the client is connected, otherwise <code>false</code>
	 */
	public boolean isConnected();
}
