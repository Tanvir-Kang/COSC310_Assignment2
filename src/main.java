import java.util.LinkedList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class main extends Response {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel postLabel;
	private static JLabel resp1;
	private static JLabel resp2;
	private static JLabel resp3;
	private static JLabel greeting;
	private static JLabel userLabel1;
	private static JLabel userLabel2;
	private static JLabel userLabel3;
	private static JTextField userText;
	private static int count = 0;
	
	static String input = null;
	static Scanner in = new Scanner(System.in);
	static boolean hasResponse=false;
	static LinkedList<String> listOfResponses = new LinkedList<>();
	static LinkedList<String> taggedResponse = new LinkedList<>();

	
	public static void main(String[] args) {
		
		frame = new JFrame(); 
		panel = new JPanel();
		frame.setSize(550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(Color.white);
		frame.add(panel);
		
		panel.setLayout(null);
	
		postLabel = new JLabel("<html><font color='Gray'>Post Malone: </font></html>");
		postLabel.setFont(postLabel.getFont().deriveFont(18f));
		postLabel.setBounds(10,40,200,25);
		panel.add(postLabel);
		
		Response r = new Response();
		r.loadResponses();
		System.out.println(r.greeting());
		
		greeting = new JLabel("");
		greeting.setText("<html>"+ r.greeting() +"</html>");
		greeting.setBounds(20,60,300,100);
		panel.add(greeting);
		
		userLabel3 = new JLabel("<html>"+""+"</html>");
		userLabel3.setBounds(300,100,190,100);
		panel.add(userLabel3);
		
		resp3 = new JLabel("");
		resp3.setBounds(20,140,300,100);
		panel.add(resp3);
		
		userLabel2 = new JLabel("<html>"+""+"</html>");
		userLabel2.setBounds(300,180,190,100);
		panel.add(userLabel2);
		
		resp2 = new JLabel("");
		resp2.setBounds(20,220,300,100);
		panel.add(resp2);
		
		userLabel1 = new JLabel("<html>"+""+"</html>");
		userLabel1.setBounds(300,260,190,100);
		panel.add(userLabel1);
		
		resp1 = new JLabel("");
		resp1.setBounds(20,300,300,100);
		panel.add(resp1);
		
		
		userText = new JTextField(20);
		userText.setBounds(20,400,400,25);
		panel.add(userText);
		
		ArrayList<String> oldResp = new ArrayList<String>(5);
		ArrayList<String> oldQues = new ArrayList<String>(5);
		 
		frame.setVisible(true);
		
		userText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	greeting.setText("");
	            	listOfResponses.clear();
	            	String[] guiInput = userText.getText().split(" ");
	            	userLabel1.setText("<html>"+ userText.getText() +"</html>");
	            	userText.setText("");
	            	count += 1;
	            	for(int i=0; i < guiInput.length; i++) {
	        			String refined = guiInput[i].replaceAll("\\s+", "");
	        			String refined2 = refined.replaceAll("[^a-zA-Z ]", "").toLowerCase();
	        	
	        			
	        			
	        			 if(responses.keySet().contains(refined2)) {
	        				hasResponse=true;
	        				listOfResponses.add(responses.get(refined2));
	        				
	        				resp1.setText("<html><font color='Gray'>"+ listOfResponses +"</font></html>");
	        				oldResp.add(resp1.getText());
	        				oldQues.add(userLabel1.getText());
	        				if(count > 1) {
		        				
	        					resp2.setText("<html><font color='Gray'>"+ oldResp.get(count-2) +"</font></html>");
	        					userLabel2.setText(oldQues.get(count-2));
		        			 }
	        				if(count > 2) {
	        					resp3.setText("<html><font color='Gray'>"+ oldResp.get(count-3) +"</font></html>");
	        					userLabel3.setText(oldQues.get(count-3));
	        					
	        				}
	        				
	        			}
	        			 else {
	        				 String[] randomResponses = new String[5];
	        					randomResponses[0] = "Sorry, I don't think I understand you.";
	        					randomResponses[1] = "I don't think I get what you're saying.";
	        					randomResponses[2] = "What do you mean by that?";
	        					randomResponses[3] = "It's hard to say honestly, I'll have to think about that.";
	        					randomResponses[4] = "I'm not sure, can you elaborate on that?";
	        					int randomNum = (int) (Math.random() * 5);
	        				 resp1.setText("<html><font color = 'red'>"+ randomResponses[randomNum] +"</font></html>");
	        				    oldResp.add(resp1.getText());
		        				oldQues.add(userLabel1.getText());
	        				 if(count > 1) {
			        				
		        					resp2.setText("<html><font color='Gray'>"+ oldResp.get(count-2) +"</font></html>");
		        					userLabel2.setText(oldQues.get(count-2));
			        			 }
		        				if(count > 2) {
		        					resp3.setText("<html><font color='Gray'>"+ oldResp.get(count-3) +"</font></html>");
		        					userLabel3.setText(oldQues.get(count-3));
		        					
		        				}
	        			
	        		}
	     
	            	}
	            	
	            }
	        }

	    });
		
		do {
			listOfResponses.clear();
		receiveInput();
		parseInput(input);
		if(listOfResponses.isEmpty()) {
			String[] randomResponses = new String[5];
			randomResponses[0] = "Sorry, I don't think I understand you.";
			randomResponses[1] = "I don't think I get what you're saying.";
			randomResponses[2] = "What do you mean by that?";
			randomResponses[3] = "It's hard to say honestly, I'll have to think about that.";
			randomResponses[4] = "I'm not sure, can you elaborate on that?";
			int randomNum = (int) (Math.random() * 5);
			System.out.println(randomResponses[randomNum]);
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
			String[] randomResponses = new String[5];
			randomResponses[0] = "Sorry, I don't think I understand you.";
			randomResponses[1] = "I don't think I get what you're saying.";
			randomResponses[2] = "What do you mean by that?";
			randomResponses[3] = "It's hard to say honestly, I'll have to think about that.";
			randomResponses[4] = "I'm not sure, can you elaborate on that?";
			int randomNum = (int) (Math.random() * 5);
			System.out.println(randomResponses[randomNum]);

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
