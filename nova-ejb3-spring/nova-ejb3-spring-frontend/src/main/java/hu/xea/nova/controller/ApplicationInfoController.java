package hu.xea.nova.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.xea.nova.ejb.ApplicationInfo;
import hu.xea.nova.ejb.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appinfo")
public class ApplicationInfoController {
	
	//@Resource(name = "applicationInfo")
	private ApplicationInfo applicationInfo;

	@ResponseBody
	@RequestMapping("/show")
	public String showInfo() {
		return applicationInfo.getInfo("");
	}
	
	@ResponseBody
	@RequestMapping("/debug")
	public String debugInfo() throws MalformedURLException, RemoteException, NotBoundException, NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://sfe469:7001");
		
		final InitialContext ctx = new InitialContext(env);
		
		final ApplicationInfo appinfo = (ApplicationInfo) ctx.lookup("ejb/appinfo#hu.xea.nova.ejb.ApplicationInfo");
		
		final String message = appinfo.getInfo("Lófaszbazdmeg");
		
		return message;
	}

	public ApplicationInfo getApplicationInfo() {
		return applicationInfo;
	}

	public void setApplicationInfo(ApplicationInfo applicationInfo) {
		this.applicationInfo = applicationInfo;
	}
}
