package hu.xea.nova.patterns.design.composite;

public class TV extends Part {
	
	final Long price = 96000L;
	
	final String name = "TV";

	@Override
	public long getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

}
