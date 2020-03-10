import java.util.Scanner;

public class main extends Response {
	
	static String input = null;
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Response r = new Response();
		r.loadResponses();
		System.out.println(r.greeting());
		receiveInput();
		parseInput(input);
	}
	
	
	private static void parseInput(String in) {
		
	}


	public static String receiveInput() {
		
		do {
			input = in.next();
		}
		while(input==null || input=="" || input.isEmpty());
		
		return null;
	}

}
