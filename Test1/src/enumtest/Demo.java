package enumtest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		Arrays.stream(EnumTest.values()).forEach(t -> names.add(t.getName()));
		for(String str: names){
			System.out.println(str);
		}
	}
}
