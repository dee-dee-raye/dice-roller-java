package userInterface;
import javax.swing.JFrame;

/**
 * This class creates the frame where the GUI will reside. 
 * A panel is added to it.
 * @author Dee Dee McCroskeu
 * @since 09/16/16
 */
public class Frame extends JFrame {
	
  /**
   * Default constructor that sets that when the exit button
   * is clicked the window will close. Creates a new panel and adds
   * it to its self.
   */
	public Frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //close when the exit button is clicked
		setTitle("Dice Roller");                           
		Panel panel=new Panel();                          //where the labels, buttons, and text fields will reside
		getContentPane().add(panel);
	}

}
