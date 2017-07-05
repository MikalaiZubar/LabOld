package exception;

public class Demo {

	public static void main(String[] args) {
		A a = new A();
	
		try {
			a.f();
		} catch (OwnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
