package CardGame;

import java.util.*;

/**
 * public SmartComputer class extends public Player class and is used by public Game class and contains inherited member name and subDeck; override method selectAttribute().
 * @author Ziwei.Lin
 *
 */

public class SmartComputer extends Player{
	
	
	/**
	 * Creates a new SmartComputer generator using a String name. 
	 * @param name
	 * the name of the SmartComputer Player.
	 */
	public SmartComputer(String name) {
		this.name = name;
	}
	

	/**
	 * Creates a new SmartComputer generator using a String name, an ArrayList cards and an integer subcardsSize.
	 * @param name
	 * the name of the SmartComputer player.
	 * @param cards
	 * the full deck of the Game.
	 * @param subcardsSize
	 * the initial subDeck that a Player holds.
	 */
	public SmartComputer (String name, ArrayList<Card>cards, int subcardsSize){ 
		this.name = name; 
		this.subDeck = this.generateSubdeck(cards, subcardsSize);
	}
	
	/**
	 * Selects the Attribute with the greatest value of the first card in the subDeck.
	 * @return Attribute a
	 * the selected Attribute of the SmartComputer Player.
	 */
	public Attribute selectAttribute(){ 
		Card card=subDeck.get(0);//first card
		int max = 0;
		int index = 0;
		for(int i = 0; i<=card.attriList.size()-1;i++){
			 if(max <= card.attriList.get(i).val){
				 max = card.attriList.get(i).val;
				 index = i;
			 }
		}
		Attribute a = card.attriList.get(index);
		return a;
	}

}
