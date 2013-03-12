package hu.xea.nova.aspects;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final TestClass tc = new TestClass();
		
		tc.doSomething();
	}

	
	public void doSomething() {
		System.out.println("doSomething()");
	}
}
