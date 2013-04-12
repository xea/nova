package hu.xea.nova.joda;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.ReadableInterval;
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
	}
	
	@Test
	public void testDurations() {
		final DateTime dateTime = new DateTime();
	}
	
	@Test
	public void testPeriod() {
	}
		
}
