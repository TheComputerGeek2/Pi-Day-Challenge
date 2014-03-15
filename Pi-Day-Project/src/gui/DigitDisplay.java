package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import main.Main;

/**
 * The display component that will be populated with the digits that the user
 * has entered so far. It should be a noneditable display which always focuses
 * on the more recent digits that the user entered.
 * 
 * @see JTextArea
 */
@SuppressWarnings("serial")
public class DigitDisplay extends JTextArea {
	public DigitDisplay() {
		super();
		super.setEditable(false);
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,
				Main.PROGRESS_FONT_SIZE));
		this.setBackground(Color.GREEN);
	}

	/**
	 * Updates the display with the most recent character entered by the user
	 * passed in as newCharacter.
	 * 
	 * @param newCharacter
	 *            the new character that the user just entered.
	 */
	public void updateDisplay(String newCharacter) {
		// this.setText(this.getText() + newCharacter);
		this.setText(newCharacter);

		// this will eventually update the display to include the last character
		// the user entered
	}

	/**
	 * Updates the display with the most recent character entered by the user
	 * passed in as newCharacter.
	 * 
	 * @param newCharacter
	 *            the new character that the user just entered.
	 */
	public void updateDisplay(char newCharacter) {
		this.updateDisplay(String.valueOf(newCharacter));
	}

	/**
	 * Clears the display of the entered digits and puts up 3. for starting
	 */
	public void clearDisplay() {
		this.setText("3."); //$NON-NLS-1$
	}

}
