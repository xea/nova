package hu.xea.nova.chat;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserConnectionTest {

	@Test
	public void testInstantiation() {
		final Connection connection = new UserConnection("user");
		
		assertNotNull("An empty user connection should be instantiable", connection);
	}

}
