package problemDomain;

/**
 * This class handles the creating of an exception 
 * object for when the number of dice requested is zero or less.
 * It allows the storing and accessing of the error message.
 * @author Dee Dee McCroskeu
 *@since 09/16/16
 */
public class NumberOfDiceException extends Exception {
		private String message;   //holds the error message
		
		/**
		 * Constructor that passes the error message onto the super 
		 * class and stores it in the member variable.
		 * @param message     Error message of having zero or less faces
		 */
		public NumberOfDiceException(String message)
		{
			super(message);
			this.message=message;
		}
		
		/**
		 * This method returns the error message passed to the constructor. 
		 * @return message    The error message.
		 */
		public String getMessage()
		{
			return message;
		}

}
