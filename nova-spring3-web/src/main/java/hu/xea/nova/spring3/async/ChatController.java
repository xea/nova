/**
 * 
 */
package hu.xea.nova.spring3.async;

import hu.xea.nova.chat.Channel;
import hu.xea.nova.chat.Message;
import hu.xea.nova.chat.User;
import hu.xea.nova.chat.impl.PublicChannel;

import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demonstrates the use of annotated spring controllers on a simple chat client.
 * 
 * @author xea
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
	
	/**
	 * Name of the login page
	 */
	public static final String PAGE_LOGIN = "login";
	
	/**
	 * Name of the update page
	 */
	public static final String PAGE_UPDATE = "update";
	
	/**
	 * Name of the main page
	 */
	public static final String PAGE_MAIN = "main";
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * The only chat channel on this controller
	 */
	private final Channel channel = new PublicChannel();
	
	/**
	 * Display the login page where the user can authenticate
	 * @return the view name
	 */
	@RequestMapping("/login")
	public String displayLogin() {
		logger.debug("Displaying login page");
		
		return PAGE_LOGIN;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(final @RequestParam(value = "username", required = true) String username, final HttpSession session) {
		logger.debug("Authentication was successful [username={}]", username);
		
		String viewName = PAGE_LOGIN;
		
		if (!channel.hasUser(username)) {
			final User user = new User(username);
			session.setAttribute("user", user);
			channel.join(user);
			
			viewName = PAGE_MAIN;
		}
		
		return viewName;
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
	
	/**
	 * Returns the message log for the current channel in plain data representation
	 * 
	 * @return the list of messages
	 */
	@RequestMapping("/log")
	public @ResponseBody List<Message> getMessageLog() {
		return channel.getMessageLog();
	}
	
	/**
	 * Refreshes the channel contents with an up-to-date content
	 * @param model the model object
	 * @return the selected view name
	 */
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String updateChannel(final Model model) {
		model.addAttribute("messages", channel.getMessageLog());
		
		return PAGE_UPDATE;
	}
	
	/**
	 * Broadcasts a message to all destinations on the selected target
	 * 
	 * @param content the message itself
	 * @param session the HTTP session object
	 * @param model the model object
	 * @return the selected view name
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String sendMessage(final @RequestParam("message") String content, final HttpSession session, final Model model) {
		final User user = (User) session.getAttribute("user");
		
		if (user != null) {
			final Message message = new Message(content);
			
			message.setFrom(user);
			channel.broadcast(message);
			logger.info("Message has been broadcasted");
		}
		
		model.addAttribute("messages", channel.getMessageLog());
		return PAGE_UPDATE;
	}
	
	@ModelAttribute("urlRoot")
	public String getPath(final HttpServletRequest request) {
		return request.getContextPath() + request.getServletPath();
	}
}
