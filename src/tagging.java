import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class tagging {
	/*this hashmap stores tagged responses, basically will be searched each time for a valid response and will
	 * just filter some responses that may not apply,slightly improves overall quality*/

		 Map<String,String> taggedResponses = new HashMap<>();
		 
	
	
	
	/*
	 * This function looks at the responses.txt file we have, and will run POS
	 * Tagging on it, it will create a new file with tagged responses
	 */
	public void translateResponses() {
		File responseFile = new File("src/responses.txt");
		File responseFileTagged = new File("src/responsesTagged.txt");
		String s;
		try {
			BufferedReader br = new BufferedReader(new FileReader(responseFile));
			MaxentTagger responseTagger = new MaxentTagger("Taggers/left3words-wsj-0-18.tagger");
	
			
				FileWriter writeTaggedFile = new FileWriter(responseFileTagged);
				
				// while loop breaks down responses into two parts and tags them in a new string
				while ((s = br.readLine()) != null) {
					String[] entry = s.split("\\:");

					String one = entry[0].trim();
					String cleanedOne = one.replaceAll("\\p{Punct}", "");
					String oneTagged = responseTagger.tagString(cleanedOne);


					String two = entry[1].trim();

					taggedResponses.put(oneTagged, two);
					
					writeTaggedFile.write(oneTagged);
					writeTaggedFile.write(" : ");
					writeTaggedFile.write(two);
					writeTaggedFile.write("\n");
				}
				writeTaggedFile.close();
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	
	public String findKey(String value) {
		for (Map.Entry<String, String> entry : taggedResponses.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		
		return null;
	}

	/* This function receives a string from main and will tag it */
	public String callTagging(String input) {
		try

		{
			MaxentTagger tagger = new MaxentTagger("Taggers/left3words-wsj-0-18.tagger");
			return tagger.tagString(input);

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
		return "Unknown error";
	}

}
