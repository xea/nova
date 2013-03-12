package hu.xea.nova.aspects;

public aspect TestAspect {

	pointcut anyMethod() : call(* hu.xea.nova.aspects.TestClass.doSomething());
	
	before(): anyMethod() {
		
		System.out.println("Before");
	}
}
