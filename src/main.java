import java.util.LinkedList;
import java.util.Scanner;

public class main extends Response {
	
	static String input = null;
	static Scanner in = new Scanner(System.in);
	static boolean hasResponse=false;
	static LinkedList<String> listOfResponses = new LinkedList<>();
	static LinkedList<String> taggedResponse = new LinkedList<>();

	
	public static void main(String[] args) {
		
		//POSTagging();
		Response r = new Response();
		r.loadResponses();
		System.out.println(r.greeting());
		do {
			listOfResponses.clear();
		receiveInput();
		parseInput(input);
		if(listOfResponses.isEmpty()) {
			System.out.println("Sorry bud I dunno what to say");
		}
		else {
		System.out.println(listOfResponses);
		}
		}
		while(true);
		}
	
	public static void POSTagging() {
										
		tagging tag = new tagging();//instantiate the new tagging class, will be able to send string to get tagged
		tag.translateResponses();
		receiveInput();//gather input from user
		
		String taggedSentence = tag.callTagging(input);//will send input to get tagged
		/*If the taggedResponses has a tagged name or variable that is the same tag and word 
		 * it will be able to generate a response, this slightly improves the quality of the 
		 * responses*/
		taggedResponse.clear();
		if (tag.taggedResponses.keySet().contains(taggedSentence)||tag.taggedResponses.containsValue(taggedSentence)) {
			//if the tag is in both a keyword and a response, add the response
			if(	tag.taggedResponses.containsValue(taggedSentence) && tag.taggedResponses.keySet().contains(taggedSentence)) {
				String reply = tag.taggedResponses.get(taggedSentence);
				
				taggedResponse.add(tag.taggedResponses.get(taggedSentence));//response
				
			}

			//else if the tag is only in a response
			else {
				taggedResponse.add(tag.taggedResponses.get(taggedSentence));
			}
			
		}
		if(taggedResponse.isEmpty()) {
			System.out.println("Sorry bud I dunno what to say");
		}
		else {
		System.out.println(taggedResponse);
		}
			
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
			System.out.println("Ask Post something: ");
			input = in.nextLine();
		}
		while(input==null || input=="" || input.isEmpty());
		
		return null;
	}

}
