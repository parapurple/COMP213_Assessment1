package CardGame;

/**
 * public Attribute class is used by public Card class, public Player class and its subclasses, public Game class and contains member name and val, methods getName() and print().
 * @author Ziwei.Lin
 *
 */

public class Attribute {
	
	public String name;
	public int val;
	
	/**
	 * Creates a new Attribute generator using String name and integer value.
	 * @param name
	 * the name of the Attribute.
	 * @param value
	 * the value of the Attribute.
	 */
	public Attribute(String name, int value){
		this.name= name;
		this.val = value;
	}
	
	/**
	 * Gets the name of the Attribute.
	 * @return String name
	 * - the name of the Attribute.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Prints out the name and value of the Attribute.	
	 */
	public void print(){
		System.out.println(" "+name+ "= "+val);
	}
}
