package exampleone;

/*
 * demonstrates how to create an anonymous class on base of usual java class
 */

public class Demo {
	static{
		System.out.println("Demo");
	}

	public static void main(String[] args) {
		
		Car car = new Car(new Engine(3, 100), Gear.AUTOMATIC);
		
		Util.print(car);  //result is false - gear is auto
		
		Util.print(new Car(new Engine(3, 100){						//anonymous class
				@Override
				public int power(int capacity, int kwt) {				//overriding power() method estimating value will be 150
					int someData = 2;
					return capacity * kwt / someData;
				}
			}, Gear.MANUAL)
		);
		
		Util.print(new Car(new Engine(3, 100){						//two anonymous classes one on base of Engine, another on base of Car
				@Override
				public int power(int capacity, int kwt) {				//overriding power() method estimating value will be 150
					int someData = 2;
					return capacity * kwt / someData;
				}
			}, Gear.MANUAL){
			@Override
			public boolean isSportCar() {			//overriding isSportCar method the result should be true in any case
				
				return true;
			}
		}
		);
		
		
		
	}

}
