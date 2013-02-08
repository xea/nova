package hu.xea.nova.spring3.async;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Initializes the Spring Dispatcher Servlet by utilizing dynamic servlet 
 * loading introduced in the Servlet API 3.0
 * 
 * @author xea
 *
 */
public class ChatInitializer implements WebApplicationInitializer {

	/**
	 * The name of the registered servlet
	 */
	public static final String SERVLET_NAME = "springDispatcher";
	
	/**
	 * The Spring servlet will serve request targeting this URL pattern
	 */
	public static final String SERVLET_MAPPING = "/s3/*";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		final Servlet servlet = new DispatcherServlet();
		
		ServletRegistration.Dynamic registration = servletContext.addServlet(SERVLET_NAME, servlet);
		registration.addMapping(SERVLET_MAPPING);
		registration.setLoadOnStartup(1);
		registration.setAsyncSupported(true);
	}

}
