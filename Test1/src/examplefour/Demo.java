package examplefour;

public class Demo {
	
	public static void main(String[] args) {
	
	/*
		Integer i = new Integer();		//if Integer lying in the same package with Demo
	
		i.printInteger(10);
		
		java.lang.Integer integer = 20;
	*/	
		
		Integer i = 20;						//the case if users Integer is lying not in the same package with Demo class
		
		
		
	//	Integer.printSMS();             //will not work because native integer will be loaded
		
		examplefourone.Integer n = new examplefourone.Integer();
		
		n.printInteger(8);
		
		
	}

}
