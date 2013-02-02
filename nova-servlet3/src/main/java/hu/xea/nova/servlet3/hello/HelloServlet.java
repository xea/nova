package hu.xea.nova.servlet3.hello;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the usage of the {@link WebServlet} annotation. 
 * 
 * By applying the {@link WebServlet} annotation this {@link Servlet} will be
 * recognized and loaded by the servlet container.
 * 
 * Every parameter can be set through annotation parameters.
 * 
 * @author xea
 *
 */
@WebServlet(displayName = "Hello Servlet", urlPatterns = { "/hello" }, initParams = { @WebInitParam(name = "param", value = "value") })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 3468065712597766885L;
	
	private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

	@Override
	public void init() throws ServletException {
		logger.info("Initializing");
		super.init();
		logger.info("Initialization complete");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Generating response");
		
		final HttpSession session = request.getSession(true);
		
		response.getOutputStream().print(String.format("Hello %s!", session.getId()));
		
		logger.info("Generation complete");
	}
	
	@Override
	public void destroy() {
		logger.info("Destroying");
		super.destroy();
		logger.info("Destroy complete");
	}
	
}
