

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

public class WordNet {
	
	/*IDictionary is the main interface for accessing WordNet dictionary Files. 
	 * Dictionary class implements IDictionary interface.
	*/
	public static String tagWord;
	public static String tagSymbol;
	public static String[] posTag;
	IIndexWord idxWord;
	public static String otherStuff;
	
	public IDictionary dictionary = null; 
	static HashMap responsesTagged = new HashMap<>();
	
	WordNet()
	{
		try
		{
			  //'path' holds the location of the WordNet dictionary files. 
			   
		      String path = "D:\\COSC 310\\PROJECT\\dict";  //HAVE TO CHANGE THIS
		      URL url = new URL("file", null, path);
	
		      // construct the dictionary object and open it
		      dictionary = new Dictionary(url);
		      dictionary.open();
		}catch (Exception e)
	    {
		      e.printStackTrace();
		}
	}
	
public static void loadResponsesTagged() {
		
		File responseFile = new File("D:\\COSC 310\\PROJECT\\trial_1\\src\\trial_1\\responsesTagged.txt");
		String s;
		try {
			BufferedReader br = new BufferedReader(new FileReader(responseFile));

			while( (s = br.readLine())!=null) {
				posTag = s.split("/", 2);
				tagWord = posTag[0].trim();
				otherStuff = posTag[1].trim();
				responsesTagged.put(tagWord, otherStuff); 
				
			}
			}
		catch(Exception e) {
				System.out.println(e);
			}
		
	}

	public void searchWord (String key) 
	{
		
		/*  A word is having a different WordId in different synsets. Each Word is having a
		 *  unique Index.  
		*/
		
		//Get  the index associated with the word in each key of responsesTagged.txt with Parts of Speech.
		if (responsesTagged.keySet().contains("NN") || responsesTagged.keySet().contains("NNS")) {
			idxWord = dictionary.getIndexWord(tagWord, POS.NOUN); 
		} else if (responsesTagged.keySet().contains("JJ") || responsesTagged.keySet().contains("JJS")) {
			idxWord = dictionary.getIndexWord(tagWord, POS.ADJECTIVE);
		} else if (responsesTagged.keySet().contains("VBN")) {
			idxWord = dictionary.getIndexWord(tagWord, POS.VERB);
		} else if (responsesTagged.keySet().contains("RBR")) {
			idxWord = dictionary.getIndexWord(tagWord, POS.ADVERB);
		}
		
		
		
	
		
		int i=1;
		
		/*getWordIDs() returns all the WordID associated with a index 
		 * 
		 */		
		for(IWordID wordID : idxWord.getWordIDs())
		{
			//Construct an IWord object to represent words associated with wordIDs
			IWord word = dictionary.getWord(wordID);
			
			
			//Get the synset in which word is present.
			ISynset wordSynset = word.getSynset();
			
		
			
			//Returns all the words present in the synset wordSynset
			for(IWord synonym : wordSynset.getWords())
			{
				synonym.getLemma();
			}

			
			//Returns the gloss associated with the synset.
			wordSynset.getGloss();
			
			
			i++;
		}
		}
	}


