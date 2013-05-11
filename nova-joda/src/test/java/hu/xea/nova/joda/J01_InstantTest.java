package hu.xea.nova.joda;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.junit.Test;

public class J01_InstantTest {

	@Test
	public void testReadableInstant() {
		final Calendar calendar = Calendar.getInstance();
		final DateTime dateTime = new DateTime();
		
		assertEquals(calendar.get(Calendar.YEAR), dateTime.year().get());
		assertEquals(calendar.get(Calendar.MINUTE), dateTime.minuteOfHour().get());
	}

	@Test
	public void testIntervals() {
		// TODO jodatime interval testcaseket megírni
	}
	
	@Test
	public void testDurations() {
		final DateTime dateTime = new DateTime();
		
		// TODO jodatime duration testcaseket megírni
	}
	
	@Test
	public void testPeriod() {
		// TODO jodatime period testcaseket megírni
	}
		
}
