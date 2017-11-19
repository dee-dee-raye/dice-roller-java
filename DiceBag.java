package problemDomain;

/**
 * This class represents a bag of multiple dice. It uses aggregation
 * because it is composed of die from the Dice class.
 * @author Dee Dee McCroskey
 * @since 09/16/16
 */
public class DiceBag {
	
	private int currentTotalRoll;	//total of what all the dice rolled
	private Dice[] dice;			//all the dice in the bag
	
	/**
	 * Default constructor. Sets member variables to zero or null.
	 */
	public DiceBag()
	{
		currentTotalRoll=0;
		dice=null;
	}
	
	/**
	 * Constructor that takes the desired number of dice and number of faces
	 * throws an exception here or from the Dice class if either is zero or less. 
	 * Creates a dice bag by filling it with individual die from the Dice class. 
	 * @param numberOfDice             Number of dice wanted
	 * @param numberOfFaces            Number of faces wanted
	 * @throws NumberOfFacesException  Exception thrown if number of faces is zero or less resides in Dice class
	 * @throws NumberOfDiceException   Exception thrown if number of dice is zero or less
	 */
	public DiceBag(int numberOfDice, int numberOfFaces) throws NumberOfFacesException, NumberOfDiceException
	{
		
		if(numberOfDice <=0)
		{
			throw new NumberOfDiceException("You cannot have zero or less dice.");
		}
		else
		{
			dice=new Dice[numberOfDice];     //creates the spots for the dice in the bag
		}
		
		currentTotalRoll=0;
		
		for(int x=0; x<dice.length; x++)
		{
			dice[x]=new Dice(numberOfFaces); //creates the dice 
		}
	}
	
	/**
	 * This method rolls all the dice in the bag by calling the roll method
	 * from the Dice class for each individual die and returns the sum of the rolls.
	 * @return currentTotalRoll     The sum of each dice rolled.
	 */
	public int rollAllDice()
	{
		currentTotalRoll=0;
		for(int x =0; x<dice.length; x++)
		{
			currentTotalRoll=currentTotalRoll+dice[x].roll();
		}
		return currentTotalRoll;
	}
	
	/**
	 * toString() method that prints each die's roll result in a line.
	 * Returns a string for easy printing.
	 * @return rollsOfDice     String of each die's result in a line.
	 */
	public String toString()
	{
		String rollsOfDice="";
		for(int x=0; x<dice.length; x++)
		{
			rollsOfDice=rollsOfDice +dice[x].toString()+ " ";
		}
		return rollsOfDice;
	}
	
	/**
	 * This method returns the sum from all the dice rolling.
	 * @return currentTotalRoll    Total of all the dice rolling.
	 */
	public int getTotalRoll()
	{
		return currentTotalRoll;
	}
	
	

}
