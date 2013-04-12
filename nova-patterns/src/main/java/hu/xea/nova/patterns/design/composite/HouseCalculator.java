package hu.xea.nova.patterns.design.composite;

public class HouseCalculator {

	public static void main(final String[] args) {

		final House house = build();
		
		house.print();
		
		System.out.println("Sum: " + house.sum());
	}
	
	public static House build() {
		final House house = new House();
		//final TV tv = new TV();
		//final Chair chair = new Chair();
		//final Computer computer = new Computer();
		//final ComputerCase ccase = new ComputerCase();
		//final HardDiskDrive hdd = new HardDiskDrive();
		
		//computer.addPart(ccase);
		//computer.addPart(hdd);
		//computer.addPart(new HardDiskDrive());
		//computer.addPart(new HardDiskDrive());
		
		//house.addPart(tv);
		//house.addPart(chair);
		//house.addPart(computer);
		
		return house;
	}
}