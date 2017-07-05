package exception;

public class A {

	public void f() throws OwnException{
		throw new OwnException("I'm a Throwable child.");
	}
	
}
