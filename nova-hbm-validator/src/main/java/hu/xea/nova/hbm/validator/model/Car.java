package hu.xea.nova.hbm.validator.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Sample class representing a Car to demonstrate how we use Validation
 * API annotations to declare validation constraints on the object.
 * 
 * @author sandor.pecsi
 *
 */
public class Car {

	@NotNull
	@Size(min = 2, max = 10)
	private String licensePlate;

	public Car() {
		super();
	}
	
	public Car(final String licensePlate) {
		this();
		this.licensePlate = licensePlate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
}
