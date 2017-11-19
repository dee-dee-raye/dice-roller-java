package problemDomain;
import java.util.*;

/**
 * This class represents a single dice. 
 * It creates dice based on a desired number of faces 
 * and rolls the dice.
 * 
 * @author Dee Dee McCroskey
 * @since 09/16/15
 */
public class Dice {
	private int numberFaces;   //holds the number of faces on the die
	private int rollResult;    //holds the result from rolling the die
	
	/**
	 * Default constructor. Sets all member variables to zero.
	 */
	public Dice()
	{
		numberFaces=0;
		rollResult=0;
	}
	
	/**
	 * This constructor takes the desired number of faces. It 
	 * creates the die, and throws an exception if the number of faces is
	 * less than or equal to zero.
	 * @param numberFaces              The number of faces wanted
	 * @throws NumberOfFacesException  Is thrown if the number is less than or equal to zero
	 */
	public Dice(int numberFaces) throws NumberOfFacesException
	{
		if(numberFaces<=0)
		{
			throw new NumberOfFacesException("You cannot have a dice with zero or less faces.");
		}
		else
		{
			this.numberFaces=numberFaces;
		}
	}
	
	/**
	 * Rolls a die by the use of a random number within
	 * the range of the die's number of faces. Stores the result
	 * in the die's rollResult variable.
	 * @return The integer representation of the result of the roll.
	 */
	public int roll()
	{
		Random randomroll=new Random();                               
		rollResult=randomroll.nextInt(numberFaces)+1; //range is 1 to number of faces
		return rollResult;
	}
	
	/**
	 * toString() method for printing out the roll results of the die.
	 * @return String representation of the die's roll result for
	 * easy printing of the die.
	 */
	public String toString()
	{
	  //space for formatting purposes when printing and for casting to String
		String result=" " + rollResult;    
		return result;
	}
	

}
