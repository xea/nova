package hu.xea.nova.mq.controller;

import org.hornetq.api.core.HornetQException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatusController {
	
	@ResponseBody
	@RequestMapping("/")
	public String doSomething() throws HornetQException {
		final String reply = "REPLY";
		
		return reply;
	}

}
