/**
 * 
 */
package hu.xea.nova.spring3.async;

import hu.xea.nova.chat.api.Channel;
import hu.xea.nova.chat.api.Message;
import hu.xea.nova.chat.api.PublicChannel;
import hu.xea.nova.chat.api.User;

import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xea
 *
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final Channel channel = new PublicChannel();
	
	public Map referenceData(final HttpServletRequest request) throws Exception {
		logger.debug("Reference data bazeg");
		return null;
	}

	@RequestMapping("/login")
	public String login() {
		logger.debug("Displaying login page");
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(final @RequestParam(value = "username", required = true) String username) {
		logger.debug("Authentication was successful [username={}]", username);
		
		String viewName = "login";
		
		if (!channel.hasUser(username)) {
			final User user = new User(username);
			channel.join(user);
		}
		
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
	
	@RequestMapping("/log")
	public @ResponseBody List<Message> getMessageLog() {
		return channel.getMessageLog();
	}
	
	@RequestMapping("/send")
	public String sendMessage(final @RequestParam("message") String content) {
		final Message message = new Message(content);
		channel.broadcast(message);
		
		System.out.println(channel.toString());
		
		logger.info("Message has been broadcasted");
		
		return "main";
	}
	
}
