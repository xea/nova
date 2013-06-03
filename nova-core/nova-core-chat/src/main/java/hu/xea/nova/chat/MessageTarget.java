package hu.xea.nova.chat;

import java.util.List;

public interface MessageTarget {

	public void receive(Message message);
	
	public List<Message> getMessageLog();
}
