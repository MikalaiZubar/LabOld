package exception;

public class OwnException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730706414121779546L;
	
	public OwnException(){};
	
	public OwnException(String message){
		super(message);
	};

}
