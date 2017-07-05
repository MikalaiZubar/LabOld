import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choise = 0;
		while(choise != 5){
			choise = scan.nextInt();
			Controller.getCommand(choise);
		}
		scan.close();
	}

}
