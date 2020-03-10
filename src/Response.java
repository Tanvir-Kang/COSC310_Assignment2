import java.io.*;
import java.util.HashMap; 
public class Response {
	
	HashMap<String,String> responses = new HashMap<>();

	
	public String greeting() {
		StringBuilder greetingSentence = new StringBuilder();
		String s;
		File file = new File("src/greeting.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			while( (s = br.readLine())!=null) {
				greetingSentence.append(s);
			}
			
			}
		catch(Exception e) {
				System.out.println(e);
				System.out.println("Cannot find greeting file specified");
				
			}
		
		return greetingSentence.toString();
	}
	
	public String response() {
		
		
		return null;
		
	}
	public void loadResponses() {
		
		File responseFile = new File("src/responses.txt");
		String s;
		try {
			BufferedReader br = new BufferedReader(new FileReader(responseFile));

			while( (s = br.readLine())!=null) {
				String[] entry = s.split("\\:");
				responses.put(entry[0],entry[1]);
			}
			
			}
		catch(Exception e) {
				System.out.println(e);
			}
		
	}
	
	
}
