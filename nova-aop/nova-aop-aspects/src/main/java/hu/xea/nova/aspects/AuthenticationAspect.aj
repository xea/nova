package hu.xea.nova.aspects;

public aspect AuthenticationAspect {

	pointcut authentication() : call(* hu.xea.nova.aop.service.AuthenticationService.authenticate(String, String));
	
	before() : authentication() {
		
		System.out.println("Before authentication");
	}
}
