import java.io.*;
import java.util.HashMap; 
public class Response {
	
	static HashMap<String,String> responses = new HashMap<>();

	
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
				String one = entry[0].trim();
				String two = entry[1].trim();
				responses.put(one,two);
			}
			}
		catch(Exception e) {
				System.out.println(e);
			}
		
	}
	
	
}
