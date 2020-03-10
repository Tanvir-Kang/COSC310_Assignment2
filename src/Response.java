import java.io.*;
public class Response {
	
	public String greeting() {
		StringBuilder greetingSentence = new StringBuilder();
		String s;
		try {
			File file = new File("src/greeting.txt");
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
	
	
}
