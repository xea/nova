package hu.xea.nova.patterns.design.composite;

public class HardDiskDrive extends Part {
	

	final Long price = 32400L;
	
	final String name = "Merevlemez";

	@Override
	public long getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

}
