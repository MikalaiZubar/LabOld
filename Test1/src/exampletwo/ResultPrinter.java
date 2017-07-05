package exampletwo;

public class ResultPrinter {
	
	
	/*
	 * method prints result if some condition is true
	 */
	
	public static void printResult(int a, int b, int c, AnyInterface someResult){
		int res = someResult.someMath(a, b);
		if(res>c){
			System.out.println(res);
		}else{
			System.out.println("Wrong condition");
		}
	} 

}
