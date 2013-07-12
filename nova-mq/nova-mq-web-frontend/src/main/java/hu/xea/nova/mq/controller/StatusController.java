package hu.xea.nova.mq.controller;

import javax.annotation.Resource;

import hu.xea.nova.mq.hornetq.HornetSender;

import org.hornetq.api.core.HornetQException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatusController {
	
	@Resource(name = "messageSender")
	private HornetSender sender;
	
	@ResponseBody
	@RequestMapping("/")
	public String doSomething() throws HornetQException {
		final String reply = "REPLY";
		
		sender.sendMessage("REQUEST");
		
		
		
		return reply;
	}

	public HornetSender getSender() {
		return sender;
	}

	public void setSender(HornetSender sender) {
		this.sender = sender;
	}

}
