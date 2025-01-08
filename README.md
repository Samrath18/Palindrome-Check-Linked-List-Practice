# Palindrome-Check

**Palindrome-Check** is a Java-based GUI application that checks whether a given phrase is a palindrome. It takes user input, removes non-alphanumeric characters, and uses a linked list to determine if the phrase reads the same forwards and backwards.

## Features

- **Palindrome Check**: The program checks if the inputted phrase is a palindrome by comparing its characters.
- **Input Sanitization**: Non-alphanumeric characters (punctuation, spaces, etc.) are automatically removed from the input.
- **Linked List Implementation**: Characters of the phrase are stored in a linked list, which is then used to compare the phrase from both ends.
- **Reset Functionality**: The program provides a reset button to clear the input field and results, allowing users to enter a new phrase.
- **Quit Functionality**: A quit button allows the user to exit the application.

## GUI Components

- **JTextField**: Used for entering the phrase to be checked.
- **JLabel**: Displays instructions and the result (whether the phrase is a palindrome or not).
- **JButton**: Three buttons:
  - **Check**: Initiates the palindrome check.
  - **Reset**: Clears the input field and result.
  - **Quit**: Exits the application.
  
## Functionality

1. **Check Palindrome**: Upon clicking the "Check" button, the application processes the input, removes non-alphanumeric characters, and checks if the phrase is a palindrome.
2. **Reset**: Clicking the "Reset" button clears the input field and hides the result label, allowing a new input to be entered.
3. **Quit**: Clicking the "Quit" button closes the application.

## Technologies Used

- Java
- Swing (for GUI components)
- Linked List (for palindrome checking)
