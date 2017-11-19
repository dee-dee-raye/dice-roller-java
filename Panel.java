package userInterface;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import problemDomain.DiceBag;
import problemDomain.NumberOfDiceException;
import problemDomain.NumberOfFacesException;

/**
 * This class creates a panel that holds the interactive
 * parts of the GUI such as buttons and text fields.
 * @author Dee Dee McCroskey
 * @since 09/16/16
 */
public class Panel extends JPanel{
	
	private JButton rollButton;        //click button to roll dice
	private JTextField numberOfDice;   //type number of dice wanted
	private int numberOfDiceNumber=0;  //holds int of number of dice requested
	private JTextField numberOfFaces;  //type number of faces wanted
	private int numberOfFacesNumber=0; //holds int of number of faces requested
	private JLabel results;            //displays the results of each dice's results
	private JLabel sum;                //displays the total of all the rolled dice
	private JLabel numberOfDiceLabel;  //label signifying text field is for number of dice
	private JLabel numberOfFacesLabel; //label signifying text field is for number of faces
	private JLabel errorLabel;         //label that displays error information
	String resultsFromRoll="";         //String to hold results of each dice's roll
	int totalOfRoll;                   //int to hold the total of all the dice's roll
	DiceBag bagOfDice;                 //dicebag of the dice being rolled
	
	/**
	 * Default constructor that creates a panel and fills it with
	 * a button for rolling, text fields for entering the desired type and number
	 * of dice, and labels explaining the results and errors.
	 */
	public Panel()
	{
		//creates label signifying that adjacent text field is for entering number of dice
		numberOfDiceLabel = new JLabel("Number of Dice: ");
		setFont(numberOfDiceLabel);
		this.add(numberOfDiceLabel);
		
		//creates text field for entering number of dice wanted
		numberOfDice=new JTextField();
		numberOfDice.setPreferredSize(new Dimension(50,25));
		numberOfDice.setFont(new Font("Zapfino", Font.BOLD, 10));
		this.add(numberOfDice);
		
		//creates label signifying that adjacent text field is for entering number of faces
		numberOfFacesLabel = new JLabel("Number of Faces: ");
		setFont(numberOfFacesLabel);
		this.add(numberOfFacesLabel);
		
		//creates text field for entering number of faces wanted
		numberOfFaces=new JTextField();
		numberOfFaces.setPreferredSize(new Dimension(50,25));
		setFont(numberOfFaces);
		this.add(numberOfFaces);
		
		//creates button that rolls the dice
		rollButton = new JButton("Roll");
		rollButton.addActionListener(new ButtonListener());
		setFont(rollButton);
		this.add(rollButton);
		
		//creates label that holds the listing of the roll result of each dice
		results = new JLabel("Results: ");
		setFont(results);
		this.add(results);
		
		//creates label that holds the total of all the dice's rolls
		sum = new JLabel("Sum: ");
		setFont(sum);
		this.add(sum);
		
		//creates label that displays error message when an error occurs
		errorLabel= new JLabel("");
		setFont(errorLabel);
		this.add(errorLabel);
		
		//set the panel's background color and size
		setBackground(Color.PINK);
		setPreferredSize(new Dimension(400,175));
		
	}
	
	/**
	 * This ineer class controls what happens when the roll button is pressed.
	 * @author Dee Dee McCroskey
	 * @since 09/16/16
	 */
	private class ButtonListener implements ActionListener
	{
	    //when the button is pressed
		public void actionPerformed(ActionEvent event)
		{
		    //clears the error label in case a previous message is there
			errorLabel.setText("");
			
			//gets entered value of number of dice and saves it as an integer
			String text = numberOfDice.getText();
			numberOfDiceNumber=Integer.parseInt(text);
		
			//gets entered value of number of faces and saves it as an integer
			String text2 = numberOfFaces.getText();
			numberOfFacesNumber=Integer.parseInt(text2);
			
			//might throw NumberOfFacesException or NumberOfDiceException
			try
			{
				bagOfDice=new DiceBag(numberOfDiceNumber, numberOfFacesNumber); //creates dice bag
				bagOfDice.rollAllDice();                                        //rolls all the dice
				resultsFromRoll=bagOfDice.toString();                           //gets the individual results
				results.setText("Results: " + resultsFromRoll);                 //sets the results label to the individual results
				totalOfRoll=bagOfDice.getTotalRoll();                           //gets the sum of all the dice rolled results
				sum.setText("Sum: " + totalOfRoll);                             //sets the sum label to the sum of all the dice rolled results
			}
			catch (NumberOfFacesException error)
			{
				results.setText("Results: Error");                              //makes results signify an error has occurred
				sum.setText("");                                                //makes sum label vanish
				errorLabel.setText(error.getMessage());                         //adds corresponding error message to error label
				add(errorLabel);                                                //adds error label to screen
			}
			catch (NumberOfDiceException error)
			{
				results.setText("Results: Error");                              //makes results signify an error has occurred
				sum.setText("");                                                //makes sum label vanish
				errorLabel.setText(error.getMessage());	                        //adds corresponding error message to error label
				add(errorLabel);                                                //adds error label to screen
			}
			
		}
		
	}
	
	/**
	 * Sets font of label to Zapfino
	 * @param label        JLabel to have font set
	 */
	void setFont(JLabel label)
	{
		label.setFont(new Font("Zapfino", Font.BOLD, 10));
	}
	
	/**
	 * Sets font of text field to Zapfino
	 * @param textField        JTextfield to have font set
	 */
	void setFont(JTextField textField)
	{
		textField.setFont(new Font("Zapfino", Font.BOLD, 10));
	}
	
	/**
	 * Sets font of button to Zapfino
	 * @param button           JButton to have font set
	 */
	void setFont(JButton button)
	{
		button.setFont(new Font("Zapfino", Font.BOLD, 10));
	}
	

	
	

}
