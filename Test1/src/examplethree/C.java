package examplethree;

import examplethree.A.B;

public class C {
	
	static{
		System.out.println("C");
	}
	
	private static void test(){
		System.out.println("test C");
	}
	
	static class D{
		
		static{
			System.out.println("D");			
		}
		
		public void print(A a, B b){
					
			System.out.println(a.getName() + " " + b.getSurname());
		}
		
		public void print(B b){
			System.out.println(b.getSurname());
		}
		
		public void print(){
			test();
		}
	}

}
