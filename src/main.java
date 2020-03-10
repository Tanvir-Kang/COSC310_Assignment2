import java.util.LinkedList;
import java.util.Scanner;

public class main extends Response {
	
	static String input = null;
	static Scanner in = new Scanner(System.in);
	static boolean hasResponse=false;
	static LinkedList<String> listOfResponses = new LinkedList<>();

	
	public static void main(String[] args) {
		Response r = new Response();
		r.loadResponses();
		System.out.println(r.greeting());
		receiveInput();
		parseInput(input);
		System.out.println(listOfResponses);
	}
	
	
	private static void parseInput(String in) {
		String[] input = in.split(" ");
		
		for(int i=0; i < input.length; i++) {
			String refined = input[i].replaceAll("\\s+", "");
			String refined2 = refined.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		
			if (responses.keySet().contains(refined2)) {

				listOfResponses.add(responses.get(refined2));
				hasResponse=true;
			}
		}
	}

	public static String receiveInput() {
		
		do {
			input = in.nextLine();
		}
		while(input==null || input=="" || input.isEmpty());
		
		return null;
	}

}
