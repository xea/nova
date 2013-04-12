package hu.xea.nova.patterns.design.composite;

public class Chair extends Part {
	
	final Long price = 4500L;
	
	final String name = "Szék";

	@Override
	public long getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

}
