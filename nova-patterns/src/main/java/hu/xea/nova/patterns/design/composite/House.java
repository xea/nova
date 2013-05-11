package hu.xea.nova.patterns.design.composite;


public class House extends Part {

	final Long price = 0L;
	
	final String name = "Ház";

	@Override
	public long getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}
	
}
