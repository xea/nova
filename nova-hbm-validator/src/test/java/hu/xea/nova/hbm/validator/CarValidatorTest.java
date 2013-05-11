package hu.xea.nova.hbm.validator;

import hu.xea.nova.hbm.validator.model.Car;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarValidatorTest {
	
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void test() {
		final Car car = new Car();
		
		final Set<ConstraintViolation<Car>> violations = validator.validate(car);
	}

}
