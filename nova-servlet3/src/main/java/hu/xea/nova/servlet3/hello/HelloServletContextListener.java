package hu.xea.nova.servlet3.hello;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates how can one set a Servlet Context Listener only by applying
 * the {@link WebListener} annotation.
 *
 * {@link ServletContextListener} objects instantiate before the initialization
 * of the {@link Servlet} and {@link Filter} objects. This mechanism allows 
 * {@link ServletContextListener} objects to prepare eg. database connections
 * or other resource initializations to be done before they are actually needed.
 * 
 * @author xea
 *
 */
@WebListener
public class HelloServletContextListener implements ServletContextListener {

	final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
	
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Servlet Context created");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("Servlet Context destroyed");
	}

}
