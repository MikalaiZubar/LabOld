import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {

	public static void main(String... str){
	
	try {
		Parent p = new SubChild();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	double v = 0.3f;
	double z = 0.1f;
	System.out.println(v-z);
	
	Child c;
	try {
		c = new Child();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	System.out.println( Parent.class.isInstance(c));
	
//	System.out.println(c instanceof Parent);
	
	/*
	Map<Integer, Mem> list = new HashMap<>();
	
	Integer i=1;
	while(true){ 
		list.put(i, new Mem(i));
		i++;
	//	System.out.println(i);
		System.out.println(list.size());
	}
	*/
	
	Exception e = new Exception(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void printStackTrace(){
			System.out.println("ha-ha");
		} 
	};
	
	try{
		throw  new Exception(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void printStackTrace(){
				System.out.println("ha-ha");
			} 
		};
	}catch(Exception ex){
		ex.printStackTrace();
	}
	
	
	//e.printStackTrace();
	
	fff();
	
	
	
	}
	
	public static int ggg() throws Exception{
		throw new Exception();
	}
	
	public static int fff(){
		throw new RuntimeException(new Exception());
	}
	
	
}
