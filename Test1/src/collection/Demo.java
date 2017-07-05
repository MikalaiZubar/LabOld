package collection;

import java.util.Stack;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		Integer a = 1;
		Integer b = 2;
		Integer cc = 3;
		Integer d = 4;
		
		st.add(a);
		st.add(b);
		st.add(cc);
		st.add(d);
		st.add(2, 10);
		
		System.out.println(st.get(2));
		System.out.println(st.remove(cc));
		System.out.println(st.isEmpty());
		System.out.println(st.empty());
		
		
		
	}

}
