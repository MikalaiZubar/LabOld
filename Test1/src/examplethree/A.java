package examplethree;

public class A {
	
	private String name;
	
	static{
		System.out.println("A");
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	class B{
		
		private String surname ;
		
		{
			System.out.println("B");
		}
		
		public String getSurname(){
			return this.surname;
		}
		
		public void setSurname(String surname){
			this.surname = surname;
		}
		
		public  String getFullName(){
			return name + " " + surname;
		}
				
	}

}
