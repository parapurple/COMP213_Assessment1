package CardGame;

import java.util.*;

/**
 * The Game class provides the core logic that satisfies all the functions include: 
 * 1. User can set their name, decide the amount of initial cards that everyone holds to play, the level of the rival(s) and finally the total number of the players;
 * 2. The code provides two kinds of logic: the fundamental TwoPlayerGame method and an advance multiPlayerGame method which can also be used in the two-player case.
 * This class also contains member playerList; methods generateDeck(), compare(), addPlayer(), printinCard() and checkList().
 * @author LZW
 *
 */

public class Game {
	
	private ArrayList<Player> playerList;
	
	/**
	 * Creates a new Game generator.
	 */
	public Game(){
	}
	
	
	/**
	 * The core logic of the card game. 
	 */
	public void run() {
		System.out.println("Welcome to the Monster Card Game!");
		System.out.print("Please enter your name: ");
		String username = Data.inputString();
		System.out.print("Please enter the initial number of cards everyone holds: ");
		int numCards = Data.inputInt();
		System.out.print("You can now choose the level of your rivals (1 = RandomComputer, 2 = PredictableComputer, 3 = SmartComputer): ");
		int level = Data.inputInt();
		System.out.print("Please enter the number of players you want to play with (include yourself 2/3/4/5): ");
		int numPlayers = Data.intRange(2, 5);
		
		ArrayList<Card> fullDeck = generateDeck(numCards*numPlayers);
		playerList = new ArrayList<Player>();
		Human me = new Human(username);
		ArrayList<Card> mydeck = me.generateSubdeck(fullDeck,numCards);
		playerList.add(me);
		
		 boolean exit = false;	        	       
	        while (!exit) {
	            switch (level) {
	                case 1:
	                	while (!exit) {
	        	            switch (numPlayers) {
	        	                case 2:
	        	                	RandomComputer r = new RandomComputer("random") ;
	        	                	ArrayList<Card> rdeck = r.generateSubdeck(fullDeck, numCards);
	        	                	TwoPlayerGame(rdeck,mydeck,r,me); 
	        	                	exit = true;
	        	                    break;
	        	                case 3:
	        	                	RandomComputer r1 = new RandomComputer("random 1",fullDeck, numCards) ;
	        	                	RandomComputer r2 = new RandomComputer("random 2",fullDeck, numCards) ;
	        	                	playerList.add(r1);
	        	                	playerList.add(r2);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                case 4:
	        	                	RandomComputer r4_1 = new RandomComputer("random 1",fullDeck, numCards) ;
	        	                	RandomComputer r4_2 = new RandomComputer("random 2",fullDeck, numCards) ;
	        	                	RandomComputer r4_3 = new RandomComputer("random 3",fullDeck, numCards) ;
	        	                	playerList.add(r4_1);
	        	                	playerList.add(r4_2);
	        	                	playerList.add(r4_3);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                case 5:
	        	                	RandomComputer r5_1 = new RandomComputer("random 1",fullDeck, numCards) ;
	        	                	RandomComputer r5_2 = new RandomComputer("random 2",fullDeck, numCards) ;
	        	                	RandomComputer r5_3 = new RandomComputer("random 3",fullDeck, numCards) ;
	        	                	RandomComputer r5_4 = new RandomComputer("random 4",fullDeck, numCards) ;
	        	                	playerList.add(r5_1);
	        	                	playerList.add(r5_2);
	        	                	playerList.add(r5_3);
	        	                	playerList.add(r5_4);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	            }
	                	}
	                	break;
	                case 2:
	                	while (!exit) {
	        	            switch (numPlayers) {
	        	                case 2:
	        	                	PredictableComputer pr = new PredictableComputer("predictable") ;
	        	                	ArrayList<Card> pdeck = pr.generateSubdeck(fullDeck,numCards);
	        	                    TwoPlayerGame(pdeck,mydeck,pr,me);
	        	                    exit = true;
	        	                    break;
	        	                case 3:
	        	                	PredictableComputer pr1 = new PredictableComputer("predictable1",fullDeck, numCards) ;
	        	                	PredictableComputer pr2 = new PredictableComputer("predictable2",fullDeck, numCards) ;
	        	                	playerList.add(pr1);
	        	                	playerList.add(pr2);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                case 4:
	        	                	PredictableComputer r4_1 = new PredictableComputer("predictable 1",fullDeck, numCards) ;
	        	                	PredictableComputer r4_2 = new PredictableComputer("predictable 2",fullDeck, numCards) ;
	        	                	PredictableComputer r4_3 = new PredictableComputer("predictable 3",fullDeck, numCards) ;
	        	                	playerList.add(r4_1);
	        	                	playerList.add(r4_2);
	        	                	playerList.add(r4_3);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                case 5:
	        	                	PredictableComputer r5_1 = new PredictableComputer("predictable 1",fullDeck, numCards) ;
	        	                	PredictableComputer r5_2 = new PredictableComputer("predictable 2",fullDeck, numCards) ;
	        	                	PredictableComputer r5_3 = new PredictableComputer("predictable 3",fullDeck, numCards) ;
	        	                	PredictableComputer r5_4 = new PredictableComputer("predictable 4",fullDeck, numCards) ;
	        	                	playerList.add(r5_1);
	        	                	playerList.add(r5_2);
	        	                	playerList.add(r5_3);
	        	                	playerList.add(r5_4);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                	
	        	            }
	                	}
	                    break;
	                case 3:
	                	while (!exit) {
	        	            switch (numPlayers) {
	        	                case 2:
	        	                	SmartComputer s = new SmartComputer("smart") ;
	        	                	ArrayList<Card> sdeck = s.generateSubdeck(fullDeck,numCards);	        	                	
	        	                	TwoPlayerGame(sdeck,mydeck,s,me);
	        	                	exit = true;
	        	                    break;
	        	                case 3:
	        	                	SmartComputer s1 = new SmartComputer("smart1",fullDeck, numCards) ;
	        	                	SmartComputer s2 = new SmartComputer("smart2",fullDeck, numCards) ;
	        	                	playerList.add(s1);
	        	                	playerList.add(s2);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                case 4:
	        	                	SmartComputer r4_1 = new SmartComputer("smart 1",fullDeck, numCards) ;
	        	                	SmartComputer r4_2 = new SmartComputer("smart 2",fullDeck, numCards) ;
	        	                	SmartComputer r4_3 = new SmartComputer("smart 3",fullDeck, numCards) ;
	        	                	playerList.add(r4_1);
	        	                	playerList.add(r4_2);
	        	                	playerList.add(r4_3);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	                case 5:
	        	                	SmartComputer r5_1 = new SmartComputer("smart 1",fullDeck, numCards) ;
	        	                	SmartComputer r5_2 = new SmartComputer("smart 2",fullDeck, numCards) ;
	        	                	SmartComputer r5_3 = new SmartComputer("smart 3",fullDeck, numCards) ;
	        	                	SmartComputer r5_4 = new SmartComputer("smart 4",fullDeck, numCards) ;
	        	                	playerList.add(r5_1);
	        	                	playerList.add(r5_2);
	        	                	playerList.add(r5_3);
	        	                	playerList.add(r5_4);
	        	                	multiPlayerGame(playerList,me);
	        	                	exit = true;
	        	                    break;
	        	            }
	                	}
	                	
	                    
	                    break;
	                default:
	                    System.out.println("Invalid option");
	                    break;
	            }
		
	        }
	}
	
	
	/**
	 * Generates initial Card deck for every Player.
	 * @param numCards
	 * the initial number of Cards held by every Player. 
	 * @return initialDeck
	 * - the initial full deck of the game. 
	 */		
	public ArrayList<Card> generateDeck (int numCards)
	{
		ArrayList<Card> initialDeck = new ArrayList<Card>();
		for ( int i =0; i< numCards; i++) 
		{
			Card card = new Card("Monster "+String.valueOf(i));
			initialDeck.add( card );
		}
		return initialDeck;
	}
	
	
	/**
	 * The fundamental method that realizes the function of two players' game. When the two Players both have Cards, the round will continue: it will first prints out all the Attributes in the first Card of each Player, human Player will select Attribute during the even rounds, and computer Player will select during the odd rounds. Then they compare the value of the selected Attribute, the Player with the biggest Attribute value will first put his own Card at the bottom of his deck then put the Card of others at the bottom of his deck, and finally all Players' Cards will be printed out. The game will stop when either one Player has no Card. 
	 * @param comdeck
	 * the subDeck held by a computer Player.
	 * @param humdeck
	 * the subDeck held by the user.
	 * @param com
	 * the computer Player.
	 * @param hum
	 * the user.
	 */
	public void TwoPlayerGame(ArrayList<Card> comdeck, ArrayList<Card> humdeck, Player com, Player hum ){
		for(int i = 0;!(comdeck.isEmpty()||humdeck.isEmpty());i++){
    		com.getCard();
    		hum.getCard();	
    		int seq;
    		if(i%2==0){
    		System.out.print("Now enter the attribute sequence number you want to choose: ");
    		seq = Data.intRange(1, 5);
    		System.out.print(com.name+" chooses: ");
    		comdeck.get(0).attriList.get(seq-1).print();
			System.out.print(hum.name+" chooses: ");
    		humdeck.get(0).attriList.get(seq-1).print();
    		}else{
    			System.out.print(com.name+" chooses: ");
    			Attribute a = com.selectAttribute();
    			a.print();
    			seq = comdeck.get(0).attriList.indexOf(a)+1;
    			System.out.print(hum.name+" chooses: ");
        		humdeck.get(0).attriList.get(seq-1).print();
    		}
    		   		
    		hum.compareTo(com, seq-1);
    		System.out.print(com.name+": ");
    		Player.printCard(comdeck);
    		System.out.print(hum.name+": ");
    		Player.printCard(humdeck);
    		
    	}
    	if(humdeck.isEmpty()){
    		System.out.println("Game Over (QAQ)");
    	}else System.out.println("Congratulations, you win! (^0^)");	    
	}
	
	
	/**
	 * The advanced method that realizes the CardGame for mutiPlayers. 
	 * Every game round will first print out the first Card that every Player picks up, then let the player select Attribute in turn and compare the value of the selected Attribute, 
	 * the Player with the biggest Attribute value will first put his own Card at the bottom of his deck then put the Card of others at the bottom of his deck, and all Players' Cards will be printed out.  
	 * The Player without any Card will be "checked out of the playerList". 
	 * The game will stop if the user is "checked out" or only one Player stays in the playerList. 
	 * @param playerList
	 * the ArrayList of all Players.
	 * @param me
	 * the Human Player (the user).
	 */
	public void multiPlayerGame(ArrayList<Player> playerList, Human me){
			
		for(int i = 0;(checkList(playerList).contains(me))&&(checkList(playerList).size()!=1);i++){
			System.out.println("********************************");
			System.out.println("********************************");
    		for(Player p:checkList(playerList)) p.getCard();
    		int AttriSeq = 0;
    		for(int remainder = 0; remainder<checkList(playerList).size();remainder++){
    		if(i%playerList.size()==remainder){
    			if(checkList(playerList).contains(playerList.get(remainder))){
    				AttriSeq = playerList.get(remainder).subDeck.get(0).attriList.indexOf(playerList.get(remainder).selectAttribute());
    				System.out.print(playerList.get(remainder).name+" chooses: ");
    				playerList.get(remainder).subDeck.get(0).attriList.get(AttriSeq).print();
    			}else{
    				AttriSeq = playerList.get(remainder).subDeck.get(0).attriList.indexOf(playerList.get(remainder).selectAttribute());
    				System.out.print(playerList.get(remainder).name+" chooses: ");
    				playerList.get(remainder).subDeck.get(0).attriList.get(AttriSeq).print();
    			}
    		}}
    		System.out.println("********************************");
       		for(int pSeq = 0; pSeq<checkList(playerList).size();pSeq++){
    		System.out.print(checkList(playerList).get(pSeq).name+" chooses: ");
    		checkList(playerList).get(pSeq).subDeck.get(0).attriList.get(AttriSeq).print();
    		}
       		
       		int max = checkList(playerList).get(0).subDeck.get(0).attriList.get(AttriSeq).val;
       		ArrayList<Player> pmaxList = new ArrayList<Player>();
       		for(int p = 0;p<checkList(playerList).size();p++){
       			if(compare(max, checkList(playerList).get(p).subDeck.get(0).attriList.get(AttriSeq).val)==1){
       				max =  checkList(playerList).get(p).subDeck.get(0).attriList.get(AttriSeq).val;
       				pmaxList.add(0,checkList(playerList).get(p));
       			}
       		}
       		addPlayer(checkList(playerList),pmaxList);
       		putinCard(pmaxList);		
       		
       		for(int x = 0; x<checkList(playerList).size();x++){
       		System.out.print(checkList(playerList).get(x).name+": ");
    		Player.printCard(checkList(playerList).get(x).subDeck);
       		}
       		       		
		}
		if(me.subDeck.isEmpty()){
    		System.out.println("Game Over (QAQ)");
    	}else System.out.println("Congratulations, you win! (^0^)");	
		
		
	}
    			
	/**
	 * Compare two integers x1 and x2. 
	 * If x1 is bigger than x2, return 0; if x1 is smaller than x2, return 1; in x1 equals to x2, return 2.	
	 * @param x1
	 * the first integer.
	 * @param x2
	 * the second integer.
	 * @return
	 * - the integer which demonstrate the compare result of the two integers.
	 */
	public int compare(int x1, int x2){
		if (x1>x2) return 0;
		else if (x1<x2) return 1;
		else return 2;
	}
	
	/**
	 * As only some of the Players in the playerList will be added into the pmaxList as they are temporarily considered to have the biggest Attribute value, the remained Players have to be added as the tail of the List too.  
	 * @param playerList
	 * the initial playerList with several Players to be added into the pmaxList.
	 * @param pmaxList
	 * the playerList begins with the Player who has the biggest Attribute value.
	 */
	public void addPlayer(ArrayList<Player> playerList, ArrayList<Player> pmaxList){
		for(int i = 0; i<playerList.size();i++){
			if (!(pmaxList.contains(playerList.get(i)))){
				pmaxList.add(playerList.get(i));
			}
		}
	}
	
	/**
	 * The Player with the biggest Attribute value will first put his own Card at the bottom of his deck then put the Card of others at the bottom of his deck.
	 * @param playerList
	 * the playerList begins with the Player who has the biggest Attribute value.
	 */
	public void putinCard(ArrayList<Player> playerList){
		playerList.get(0).putCard(playerList.get(0).subDeck.get(0));
		playerList.get(0).remove();
		for(int i = 1; i<playerList.size();i++){
			playerList.get(0).putCard(playerList.get(i).subDeck.get(0));
			playerList.get(i).remove();
		}
	}
	
	/**
	 * Checks the playerList in order to remove all the Players without any Card.
	 * @param playerList
	 * the initial playerList with all the Players.
	 * @return ArrayList playerList
	 * - the playerList without Players whose subDeck is empty.
	 */
	public ArrayList<Player> checkList (ArrayList<Player> playerList){
		for(int i = 0; i<playerList.size();i++){
			if(playerList.get(i).subDeck.isEmpty()){
				playerList.remove(playerList.get(i));
			}
		}
		return playerList;
	}
	
}
	
		



