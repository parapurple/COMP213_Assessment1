package CardGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * public Card class is used by public Player class and its subclasses, public Game class and contains member attriList, name and random; methods getName(), print() and printName().
 * @author Ziwei.Lin
 *
 */
public class Card {

	protected ArrayList<Attribute> attriList;
	private String name;
	private Random random = new Random();
	
	/**
	 * Creates a new Card generator.
	 */
	public Card(){}
	
	/**
	 * Creates a new Card generator using a String name.
	 * @param name
	 * the name of the Card.
	 */
	public Card (String name) 
	{ 
	 	this.name = name;
	 	attriList = new ArrayList<Attribute>();
		attriList.add(new Attribute("1.Attack", random.nextInt(100)));
		attriList.add(new Attribute("2.Defence", random.nextInt(100)));
		attriList.add(new Attribute("3.Speed", random.nextInt(100)));
		attriList.add(new Attribute("4.Blood", random.nextInt(100)));
		attriList.add(new Attribute("5.Energy", random.nextInt(100)));
	}

		
	/** 
	* Prints out the name and all attributes of the card.
	*/	
	public void print(){
		System.out.println("*****"+ name);
		for (Attribute a:attriList)a.print();
	}
   
	/**
	 * Prints out only the name of the card.
	 */
	public void printName(){
		System.out.print(""+ name+"; ");
	}


	 
	

}
