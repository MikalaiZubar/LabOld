package examplethree;

public class Demo {
	
	static{
		System.out.println("Demo");
	}

	public static void main(String[] args) {
		
	//	C c = new C();  //class C will be loaded
				
		C.D d = new C.D();			//only class B will be loaded
		
		
	//	A.B b = new A().new B();		//classes A and B will be loaded
		
		A a = new A();
		A.B b = a.new B();
		
	//	a.setName("Bob");
		b.setSurname("Smith");
		
	//	d.print(a, b);
		
		d.print(b);
		
	//	C c = new C();  //class C will be loaded
		
	//	d.print();		//class C will be loaded
		
		
		
	}
}
