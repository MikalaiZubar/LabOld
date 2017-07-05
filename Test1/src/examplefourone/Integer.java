package examplefourone;

public class Integer {
	
	public void printInteger(int a){
		Integers[] vals  = Integers.values();
		System.out.println(vals[a-1]);
	}
	
	public enum Integers{
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
	}

}
