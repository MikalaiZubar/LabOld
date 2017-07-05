
public class Parent {

	public int y=4;
	
	public Parent() throws Exception{
		print();
		System.out.println(y);
		throw new Exception();
	}
	
	public void print(){
		System.out.println(y);
	}
}
