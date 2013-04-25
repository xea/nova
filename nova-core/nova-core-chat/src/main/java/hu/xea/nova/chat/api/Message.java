package hu.xea.nova.chat.api;


/**
 * A message that can be forwarded between clients and channels
 * @author xea
 *
 */
public class Message {
	
	private String content;
	
	private Client from;
	
	private Client to;

	public Message(final String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public Client getFrom() {
		return from;
	}

	public void setFrom(Client from) {
		this.from = from;
	}

	public Client getTo() {
		return to;
	}

	public void setTo(Client to) {
		this.to = to;
	}
}
