import java.util.HashMap;
import java.util.Map;

public class Controller {
	
	private static Map<Integer, ICommand> commandMap;
	
	static{
		commandMap = new HashMap<>();
		commandMap.put(1, new HelloNaveenCommand());
		commandMap.put(2, new HelloJackCommand());
		commandMap.put(3, new HelloAlexCommand());
		commandMap.put(5, new ByeCommand());
	}
	
	public static void getCommand(int numOfCommand){
		commandMap.get(numOfCommand).execute();
	}

}
