package userInterface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import problemDomain.Dice;
import problemDomain.DiceBag;

/**
 * This class is the lead on controlling the dice roller. It creates the frame
 * which creates the panel where a lot of the action takes place.
 * @author DeeDee
 * @since 09/16/16
 */
public class UserInterface{
	
	public static void main(String args[])
	{
		JFrame frame = new Frame();
		frame.pack();		           //set the size of the frame based on content
		frame.setVisible(true);        //allows us to see the frame
	}
}
