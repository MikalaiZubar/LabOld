package exampletwo;

public class Demo {
	
	
	

	public static void main(String[] args) {
		
		int a = 6;
		int b = 5;
		int c = 10;
		/*
		 * three printResult() in each we are creating anonymous classes
		 * with different realization of  someMath() method
		 */
		
		ResultPrinter.printResult(a, b, c, new AnyInterface() {
			@Override
			public int someMath(int a, int b) {
				return a + b;
			}
		});
		
		ResultPrinter.printResult(a, b, c, new AnyInterface() {
			@Override
			public int someMath(int a, int b) {
				return a * b;
			}
		});
		
		ResultPrinter.printResult(a, b, c, new AnyInterface() {
			@Override
			public int someMath(int a, int b) {
				return a - b;
			}
		});
		
		System.out.println(exampletwo.Demo.class.getClassLoader());
		

	}

}
