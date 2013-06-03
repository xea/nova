package hu.xea.nova.osgi.tycho.client;

import hu.xea.nova.osgi.tycho.SampleService;

public class SampleClient {
	
	private SampleService service;

	public void init() {
		System.out.println("Init client");
	}
	
	public void method() {
		System.out.println("Destroy client");
	}

	public SampleService getService() {
		return service;
	}

	public void setService(SampleService service) {
		this.service = service;
	}
}
