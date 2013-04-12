package hu.xea.nova.patterns.design.composite;

public class ComputerCase extends Part {


	final Long price = 4550L;
	
	final String name = "Számítógépház";

	@Override
	public long getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

}
