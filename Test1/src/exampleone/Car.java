package exampleone;

public class Car {
	
	private Engine eng;
	private Gear gear;
	
	static{
		System.out.println("Car");
	}
	
	public Car(Engine eng, Gear gear){
		this.eng = eng;
		this.gear = gear;
	}
	
	
	
	
	public Engine getEng() {
		return eng;
	}




	public Gear getGear() {
		return gear;
	}




	public boolean isSportCar(){
		return eng.power(eng.getCapacity(), eng.getKwt()) > 200 && gear.toString().equals("MANUAL");
	}
	

}
