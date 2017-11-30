package CardGame;

import java.util.*;

/**
 * public Player class is used by public Game class and contains member name, subDeck and random; methods generateSubdeck(), getCard(), selectAttribute(),remove(), putCard(), compareTo() and printCard().
 * @author Ziwei.Lin
 *
 */

public abstract class Player {
	
	protected String name;
	protected ArrayList <Card> subDeck;
	protected Random random = new Random();
	
	/**
	 * Creates a new Player generator.
	 */
	public Player() {}
	
	/**
	 * Creates a new Player generator using a single String name.
	 * @param name
	 * the name of the Player.
	 */		
	public Player (String name){
		this.name = name;
	}
	
	/**
	 * Generate the initial subDeck that a Player holds.
	 * @param cards
	 * the full deck of the Game.
	 * @param subcardsSize
	 * the initial number of Cards everyone holds which is set by user. 
	 * @return AttayList subDeck
	 * - the initial subDeck that a Player holds.
	 */
	public ArrayList<Card> generateSubdeck (ArrayList<Card>cards, int subcardsSize){
		subDeck = new ArrayList<Card>();
		for(int i=0; i<= subcardsSize-1;i++){
			int r = random.nextInt(cards.size());
			subDeck.add(cards.get(r));
			cards.remove(cards.get(r));
		}
		return subDeck;
	}
	
	
	/**
	 * Prints out the card name at the top of the subDeck.
	 */
	public void getCard(){
		System.out.println(name+": ");
		Card card = subDeck.get(0);
		card.print();
	}
	
	/**
	 * Randomly selects an Attribute of the first card in the subDeck. 
	 * @return Attribute a
	 * - the selected Attribute which will be used to be compared with others.
	 */
	public Attribute selectAttribute(){ 
		 Card card=subDeck.get(0);//first card
		 Attribute a=card.attriList.get((int)(Math.random()*4));
		 return a;
	 }
	
	/**
	 * Remove the card at the top of the subDeck.
	 */
	public void remove(){
		subDeck.remove(0);
	}
	
	/**
	 * Put the card at the bottom of the subDeck.
	 * @param card
	 * the Card that the Player win and put into the bottom of the subDeck.
	 */
	public void putCard(Card card){
		subDeck.add(card);		
	}
	
	/**
	 * Compare the selected Attribute value, return integer 0/1/2 that represents three status (bigger than/ smaller than/ equal to). 
	 * @param player
	 * the Player whose Attribute will be compared.
	 * @param attributeSeq
	 * the sequence number of the selected Attribute. 
	 */
	public void compareTo(Player player, int attributeSeq){
		Attribute a1 = this.subDeck.get(0).attriList.get(attributeSeq);
		if (a1.val>player.subDeck.get(0).attriList.get(attributeSeq).val){
			this.putCard(this.subDeck.get(0));
			this.putCard(player.subDeck.get(0));
			this.remove();
			player.remove();
		}else if(a1.val<player.subDeck.get(0).attriList.get(attributeSeq).val){
			player.putCard(player.subDeck.get(0));
			player.putCard(this.subDeck.get(0));
			player.remove();
			this.remove();
		}else{ 
		}
	}
	
	/**
	 * Prints only the name of every Cards in a deck.
	 * @param deck
	 * the deck of Cards that need to be printed.
	 */
	public static void printCard(ArrayList<Card> deck){
		for (Card c: deck) c.printName();
		System.out.println();
	}
	
}
