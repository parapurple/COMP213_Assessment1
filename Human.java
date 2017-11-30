package CardGame;



/**
 * public Human class extends public Player class and is used by public Game class and contains inherited member name and subDeck; override method selectAttribute().
 * @author LZW
 *
 */

public class Human extends Player{
	
	
		/**
		 * Creates a new Human generator using a String name.
		 * @param name
		 * the name of the Human Player.
		 */
		public Human(String name){
			this.name = name;
		}
		
				
		/**
		 * Selects an Attribute of the first card by getting the index from the user input. 
		 * @return Attribute a
		 * the selected Attribute which will be used to be compared with others.
		 */
		public Attribute selectAttribute(){ 
			 Card card=subDeck.get(0);//first card
			 System.out.print("Now enter the attribute sequence number you want to choose: ");
	    	 int s = Data.intRange(1, 5);
			 Attribute a=card.attriList.get(s-1);
			 return a;
	}

}
