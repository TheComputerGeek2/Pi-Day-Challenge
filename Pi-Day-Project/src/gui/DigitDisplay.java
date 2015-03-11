package gui;

import java.awt.Color;

import javax.swing.JTextArea;

import main.Config;

/**
 * The display component that will be populated with the digits that the user
 * has entered so far. It should be a non-editable display which always focuses
 * on the more recent digits that the user entered.
 * 
 * @see JTextArea
 */
@SuppressWarnings("serial")
public class DigitDisplay extends JTextArea {

	public DigitDisplay() {
		super();
		super.setEditable(false);
		this.setFont(Config.PROGRESS_FONT);
		this.setBackground(Color.GREEN);
	}

	/**
	 * <strong>updateDisplay</strong>
	 * <p>
	 * public void <strong>updateDisplay</strong>(String newCharacter)
	 * <p>
	 * 
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
	 * <strong>updateDisplay</strong>
	 * <p>
	 * public void <strong>updateDisplay</strong>(char newCharacter)
	 * <p>
	 * 
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
	 * <strong>clearDisplay</strong>
	 * <p>
	 * public void <strong>clearDisplay</strong>()
	 * <p>
	 * 
	 * Clears the display of the entered digits and puts up 3. for starting
	 */
	public void clearDisplay() {
		this.setText("3."); //$NON-NLS-1$
	}

}
