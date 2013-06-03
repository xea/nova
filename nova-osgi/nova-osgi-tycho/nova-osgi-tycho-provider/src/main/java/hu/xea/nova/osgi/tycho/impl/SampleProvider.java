package hu.xea.nova.osgi.tycho.impl;

import hu.xea.nova.osgi.tycho.SampleService;

public class SampleProvider implements SampleService {
	
	public void init() {
		System.out.println("Init");
	}
	
	public void destroy() {
		System.out.println("Destroy");
	}

	@Override
	public String getApplicationName() {
		return "Tycho OSGI basz";
	}

}
