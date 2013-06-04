package hu.xea.nova.owasp;

import org.junit.Assert;
import org.junit.Test;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.reference.DefaultEncoder;

public class DefaultEncoderTest {
	
	@Test
	public void testDefaultEncoderForHTML() {
		Encoder encoder = new DefaultEncoder(null);
		System.out.println(encoder.encodeForHTML("<script>alert('asdf');</script>"));
	}

}
