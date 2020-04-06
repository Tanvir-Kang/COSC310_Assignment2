

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.ISynsetID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.morph.WordnetStemmer;
import edu.mit.jwi.item.POS;


public class DemoWordNet  extends WordNet {
	
	
	public static void main(String args [])
	{
		
		WordNet w = new WordNet();
		loadResponsesTagged();
		
		for(int i = 0; i < responsesTagged.size(); i++) {
			tagWord = posTag[i].trim();
			w.searchWord(tagWord);
		}
		
	}
	
	
}
