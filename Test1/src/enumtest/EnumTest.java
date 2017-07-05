package enumtest;

public enum EnumTest {
	MEAT(11, "meat"), MILK(5, "milk"), SALAD(4, "salad");
	
	private int data;
	private String name;
	
	private EnumTest(int data, String name){
		this.data = data;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	

}
