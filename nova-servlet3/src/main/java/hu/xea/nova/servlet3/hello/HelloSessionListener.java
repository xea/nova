package hu.xea.nova.servlet3.hello;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class HelloSessionListener implements HttpSessionListener {

	private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
	
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		logger.info("Session created: " + sessionEvent.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		logger.info("Session destroyed: " + sessionEvent.getSession().getId());
	}

}
