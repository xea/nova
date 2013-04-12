package hu.xea.nova.patterns.design.composite;

public class Computer extends Part {

	final Long price = 15000L;
	
	final String name = "Számítógép";

	@Override
	public long getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

}
