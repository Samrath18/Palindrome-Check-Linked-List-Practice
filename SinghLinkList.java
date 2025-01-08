/*
 * Samrath Singh
 * ICS4UO-B
 * Linked List
 * 2023/03/27
 * This program allows a user to enter a phrase in order to check whether it is a palindrome or not.
 * Any characters other than letters and numbers are removed from the input value.
 * The program will output whether the inputed value is a palindrome or not.
 * A reset button can be clicked to reset the textfield and enter a new phrase.
 * A quit button can be clicked to exit the program.
 */
package linklist;

import java.awt.EventQueue; //import all items
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * This is the main class
 * @author Samrath Singh
 */
public class SinghLinkList extends JFrame {

	//Declare all class variables
	
	//Declare GUI components
	private static JPanel contentPane;
	private static JButton bCheck, bReset, bQuit;
	private static JLabel lblResult, lblCaption, lblWelcome;
	private static JTextField textField;
	
	private SinghPalindrome head; //Declare SinghPalindrome variable head
	private String data; //Declare string variable data
	private int length; //Declare int variable length

	/**
	 * Main method of class
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinghLinkList frame = new SinghLinkList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * This method is used to call other methods.
	 */
	private SinghLinkList() {
		
		buildGUI(); //Call method
		
		actionListeners(); //Call method
	}

	/**
	 * This method is used to initialize and build the GUI.
	 */
	private void buildGUI() {

		//Initialize all GUI components
		setTitle("Samrath Singh Palindrome Checker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		bCheck = new JButton("Check");
		bCheck.setBounds(10, 170, 89, 23);
		contentPane.add(bCheck);

		bQuit = new JButton("Quit");
		bQuit.setBounds(257, 170, 89, 23);
		contentPane.add(bQuit);

		bReset = new JButton("Reset");
		bReset.setBounds(134, 170, 89, 23);
		contentPane.add(bReset);
		
		lblWelcome = new JLabel("<html>Enter a phrase and click 'Check' to check whether it is a palindrome or not.<br/>Any characters other than letters and numbers will be ignored.<html>");
		lblWelcome.setBounds(10, 11, 336, 68);
		contentPane.add(lblWelcome);

		lblResult = new JLabel();
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(215, 131, 131, 29);
		contentPane.add(lblResult);

		lblCaption = new JLabel("Enter Text Here:");
		lblCaption.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaption.setBounds(10, 90, 131, 29);
		contentPane.add(lblCaption);

		textField = new JTextField();
		textField.setBounds(10, 117, 131, 29);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	/**
	 * This method is used to insert the characters of the user's input into the linklist.
	 * @param data
	 * @param idx
	 */
	public void insertAtHead(String data, int idx) {
		
		SinghPalindrome newChar = new SinghPalindrome(data, idx); //Creating the object
		newChar.setNext(this.head); //Setting the next value as head variable
		if(this.head != null) { //Loop unless this.head equals null
			this.head.setPrevious(newChar); //Set previous of this.head as newChar
		}
		this.head = newChar; //Set this.head as newChar
	}
	
	/**
	 * This method is used to check whether the user's input is a palindrome or not.
	 */
	public void palindromeChecker() {
		SinghPalindrome first = this.head; //Set first as this.head
		SinghPalindrome last = this.head; //Set last as this.head
		int idx = 0; //Create local variable idx
		while(last != null) { //Loop until last equals null
			if(idx == length - 1) { //If idx equals length - 1
				break; //Break the loop
			}
			last = last.getNext(); //Set last as last.getNext
			idx++; //Increase idx counter by 1
		}
	
		boolean flag = true; //Start flag as true
		for(int i = 0; i < length; i++) { //For counter i equals 0, i is less than length, and i++
				if(first != null && last != null) { //If first and last do not equal null
					if(!first.getData().equalsIgnoreCase(last.getData())) { //If first.getData does not equal last.getData
				
						flag = false; //Return flag as false
						break; //Break the loop
					}
				}
			first = first.getNext(); //First equals first.getNext
			last = last.getPrevious(); //Last equals last.getPrevious
		}
		if (!flag) { //If flag is false
			lblResult.setText("It is not a palindrome!"); //Setting the text for the label
			lblResult.setVisible(true); //Setting the label visible
		} else { //Else it is true
			lblResult.setText("It is a palindrome!"); //Setting the text for the label
			lblResult.setVisible(true); //Setting the label visible
		}
	}	

	/**
	 * Action Listeners for buttons.
	 */
	private void actionListeners() {		
		bCheck.addActionListener(new ActionListener() { //listener for the JButton bCheck
			public void actionPerformed(ActionEvent e) {
				data = textField.getText().replaceAll("[\\p{Punct}\\s+-]", "").toLowerCase().trim(); //Remove all characters except for letters and numbers.
				length = data.length(); //Get length of phrase
								
				String testData = data; //Set as a string variables
				
				for(int i = 0; i < testData.length(); i++) { //Loop to place characters in a linklist
					insertAtHead(String.valueOf(testData.charAt(i)),i+1); //Call method and send data
				}
				
				palindromeChecker(); //Call method
				
				bCheck.setEnabled(false); //Disenable button
				textField.setEnabled(false); //Disenable textfield
			}		
		});
		bReset.addActionListener(new ActionListener() { //listener for the JButton bReset
			public void actionPerformed(ActionEvent e) {
			textField.setText(null); //Remove text from textfield
			lblResult.setVisible(false); //Make lblResult invisible
			bCheck.setEnabled(true); //Enable bCheck
			textField.setEnabled(true); //Enable textfield
			}
		});
		bQuit.addActionListener(new ActionListener() { //listener for the JButton bQuit
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT); //End program
			}
		});
	}
}