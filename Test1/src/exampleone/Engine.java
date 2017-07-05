package exampleone;

public class Engine {
	
	private int capacity;
	private int kwt;
	
	static{
		System.out.println("Engine");
	}
	
	public Engine(int capacity, int kwt){
		this.capacity = capacity;
		this.kwt = kwt;
	}
	
	public int power(int capacity, int kwt){
		return capacity * kwt;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getKwt() {
		return kwt;
	}
	
	 

}
