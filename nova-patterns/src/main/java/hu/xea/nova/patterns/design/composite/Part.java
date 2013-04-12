package hu.xea.nova.patterns.design.composite;

import java.util.HashSet;
import java.util.Set;

public abstract class Part {

	protected final Set<Part> parts = new HashSet<Part>();
	
	public abstract long getPrice();
	
	public abstract String getName();
	
	public void addPart(final Part part) {
		this.parts.add(part);
	}
	
	public void print() {
		System.out.println(getName() + ", ára: " + getPrice());
		
		for (final Part houseItem : parts) {
			houseItem.print();
		}
		
	}

	public Long sum() {
		Long price = getPrice();
		
		for (final Part part : parts) {
			price += part.getPrice();
		}
		
		return price;
	}
}
