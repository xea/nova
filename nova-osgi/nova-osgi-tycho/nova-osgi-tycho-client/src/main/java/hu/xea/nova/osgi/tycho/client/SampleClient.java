package hu.xea.nova.osgi.tycho.client;

import org.osgi.service.log.LogService;

import hu.xea.nova.osgi.tycho.SampleService;

public class SampleClient {
	
	private SampleService service;
	
	private LogService logger;

	public void init() {
		logger.log(LogService.LOG_WARNING, "SampleClient start");
		logger.log(LogService.LOG_WARNING, "ApplicationName: " + service.getApplicationName());
	}
	
	public void destroy() {
		logger.log(LogService.LOG_WARNING, "SampleClient stop");
	}

	public SampleService getService() {
		return service;
	}

	public void setService(SampleService service) {
		this.service = service;
	}

	public LogService getLogger() {
		return logger;
	}
	
	public void setLogger(LogService logger) {
		this.logger = logger;
	}
}

