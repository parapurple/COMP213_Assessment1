package CardGame;

import java.util.*;

/**
 * public RandomComputer class extends public Player class and is used by public Game class and contains inherited member name and subDeck; override method selectAttribute().
 * @author Ziwei.Lin
 *
 */

public class RandomComputer extends Player{
	

	/**
	 * Creates a new RandomComputer generator using a String name.
	 * @param name
	 * the name of the RandomComputer Player.
	 */
	public RandomComputer (String name){
		this.name = name;
	}

	/**
	 * Creates a new RandomComputer generator using a String name, an ArrayList cards and an integer subcardsSize.
	 * @param name
	 * the name of the RandomComputer player.
	 * @param cards
	 * the full deck of the Game.
	 * @param subcardsSize
	 * the initial subDeck that a Player holds.
	 */
	public RandomComputer (String name, ArrayList<Card>cards, int subcardsSize){ 
		this.name = name; 
		this.subDeck = this.generateSubdeck(cards, subcardsSize);
	}
	
	/**
	 * Randomly selects an Attribute of the first card in the subDeck. 
	 * @return Attribute a
	 * the selected Attribute of the RandomComputer Player.
	 */
	public Attribute selectAttribute(){ 
		 Card card=subDeck.get(0);//first card
		 Attribute a=card.attriList.get((int)(Math.random()*4));
		 return a;
	 }


}
