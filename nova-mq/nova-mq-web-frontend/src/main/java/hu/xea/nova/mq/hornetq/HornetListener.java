package hu.xea.nova.mq.hornetq;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HornetListener implements MessageListener {

	private final Logger logger = LoggerFactory.getLogger(HornetListener.class);
	
	@Override
	public void onMessage(Message message) {
		logger.info("Got message: " + message);
	}

}
