package CardGame;

import java.util.*;

/**
 * public Data class is used by any class when it needs to get value from user input and contains member kb; methods inputString(), inputInt() and intRange().
 * @author Ziwei.Lin
 *
 */

public class Data {

	public static Scanner kb = new Scanner(System.in);
	
	/**
	 * This is a String input method.
	 * @return String
	 * - the String that user inputs.
	 */
	public static String inputString() {
        return kb.nextLine();
    }
	
	/**
	 * This is an Integer input and validation checking method.
	 * @return int i
	 * - the integer that user inputs.
	 */
	public static int inputInt() {
        int i = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter an integer: ");
            String s = inputString();
            try {
                i = Integer.parseInt(s);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer");
            }
        }
        return i;
    }
	
	/**
	 * Input an integer range from integer a to integer b.
	 * @param a
	 * the smallest number of the range.
	 * @param b
	 * the biggest number of the range.
	 * @return integer
	 * - the integer that range from a to b that user inputs.
	 */
	public static int intRange(int a,int b){
		int i = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter an integer ("+a+" to "+b+"): ");
            String s = inputString();
            try {
                i = Integer.parseInt(s);
                if(i>=a&&i<=b){
                validInput = true;}
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer");
            }
        }
        return i;
	}

}
