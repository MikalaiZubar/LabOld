package examplefive;


import java.awt.Rectangle;
import java.util.Locale;
import java.util.spi.CalendarDataProvider;

public class Demo {

	public static void main(String[] args) {
		
		Integer ty = 5;
		
		MyInteger my = new MyInteger();
			
		
		boolean b = (my instanceof Number);
						
		System.out.println( b );
		
		
		System.out.println(ty.getClass().getClassLoader()); //null - loaded by bootstrap
		
		System.out.println(my.getClass().getClassLoader());
		
	}
}
