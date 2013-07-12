package hu.xea.nova.mq.hornetq;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

public class HornetSender {

	private ConnectionFactory connectionFactory;
	
	private Destination destination;
	
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final String message) {
		jmsTemplate.convertAndSend(message);
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
