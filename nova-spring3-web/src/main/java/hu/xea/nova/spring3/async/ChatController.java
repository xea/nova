/**
 * 
 */
package hu.xea.nova.spring3.async;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xea
 *
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/login")
	public String login() {
		logger.debug("Displaying login page");
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(final @RequestParam(value = "username", required = true) String username) {
		logger.debug("Authentication was successful [username={}]", username);
		
		return "main";
	}
	
	@Async
	@RequestMapping(value = "/async")
	public Callable<String> asynchronousRequest() {
		logger.debug("Calling asynchronous request");
		
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				logger.debug("Asynchronous request handler start");
				Thread.sleep(2000);
				logger.debug("Asynchronous request handler end");
				return "main";
			}
		};
	}
}
