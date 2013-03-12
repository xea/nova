package hu.xea.nova.aop.service;

public class AuthenticationService {

	public boolean authenticate(final String username, final String password) {
		System.out.println("adsfasfd");
		return false;
	}
	
	public static void main(final String[] args) {
		final AuthenticationService as = new AuthenticationService();
		
		as.authenticate("myname", "myPassword");
	}

}
