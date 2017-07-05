
public class SubChild extends Child{
	public int z=5;
	public String hi = "Hi";
	public Child child = new Child();
	
	public SubChild() throws Exception{
		super();
		
	}
	
	public void print(){
		System.out.println(hi + " " + z +" "+child.toString());
	}
}
