package hu.xea.nova.chat.api;

import java.util.List;

/**
 * A Channel is a place where {@link User}s can meet each other and see each others
 * messages.
 * 
 * @author xea
 *
 */
public interface Channel extends MessageTarget {
	
	/**
	 * Return the name of the channel
	 * 
	 * @return channel name
	 */
	public String getName();

	/**
	 * Remove a user from the channel
	 * @param user user to kick
	 * @param reason why the user was kicked
	 */
	public void kick(User user, String reason);
	
	/**
	 * Invites a user to this channel
	 * 
	 * @param user the user to be invited
	 */
	public void invite(User user);
	
	/**
	 * Adds the specified user to the channel
	 * 
	 * @param user user to add
	 */
	public void join(User user);
	
	/**
	 * Delivers the given message to every user on the channel
	 * 
	 * @param message message to deliver
	 */
	public void broadcast(Message message);
	
	/**
	 * Indicates if this channel already contains a user with the given nickname
	 * 
	 * @param nickname the nickname
	 * @return <code>true</code> if the channel has a user with this name, otherwise <code>false</code>
	 */
	public boolean hasUser(final String nickname);
	
}
