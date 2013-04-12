package hu.xea.nova.servlet3.hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the usage of the {@link WebFilter} annotation. 
 * 
 * Only by applying the {@link WebFilter} annotation, the {@link Filter} will
 * be recognized and loaded by the Servlet container. 
 * 
 * @author xea
 *
 */
@WebFilter(displayName = "Hello Filter", urlPatterns = "/*")
public class HelloFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
	
	/**
	 * Initializes this Filter.
	 * 
	 * This implementation only appends a few messages to the log indicating that the filter has been initialized correctly
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Initializing");
		logger.info("Initialization complete");
	}

	/**
	 * Does the actual filtering, allowing the filters to modify the handler chain
	 * 
	 * This implementation does nothing save for a little logging.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, 	FilterChain filterChain) 
			throws IOException, ServletException {

		logger.info("Passing request to next filter");
		filterChain.doFilter(request, response);
		logger.info("Returning from previous filter");
	}

	/**
	 * Destroys this filter.
	 * 
	 * This implementation does nothing save for a little logging.
	 */
	public void destroy() {
		logger.info("Destroying");
		logger.info("Destroy complete");
	}

}
