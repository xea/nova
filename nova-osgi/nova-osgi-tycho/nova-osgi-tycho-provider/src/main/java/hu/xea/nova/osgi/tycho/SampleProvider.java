package hu.xea.nova.osgi.tycho;

public class SampleProvider implements SampleService {

	@Override
	public String getApplicationName() {
		return "Tycho OSGI basz";
	}

}
