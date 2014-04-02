package gui;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JTextField;

import main.Config;

public class PiInputField extends JTextField implements KeyListener {

	/**
	 * Represents the file that contains the digits of pi. This should be fixed
	 * later.
	 */
	public static final String PI_FILE = "W:\\Staff_Student\\jjmiller\\Writeable\\Pi.txt";

	/**
	 * Instantiates the default input field for the gui. Loads with the
	 * listeners ready and the font set.
	 */
	public PiInputField() {
		super();
		new AccuracyChecker(this, new File(PiInputField.PI_FILE));
		this.addKeyListener(this);
		this.setFont(Config.INPUT_FONT);
		this.setBackground(Config.INPUT_FIELD_IN_PROGRESS_COLOR);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == Config.RESTART_KEYCODE) {
			AccuracyChecker.reload();
			System.out.println("Accuracy Checker is Reloading");
			return;
		}
		Toolkit.getDefaultToolkit().sync();
		boolean isRight = AccuracyChecker.checkNextDigit(this.getText());
		if (!isRight) {
			this.failSequence();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	/**
	 * Prevents the user from making further edits to the input field and
	 * changes the background to red. Should be called when the user makes a
	 * mistake.
	 */
	public void failSequence() {
		this.setEditable(false);
		this.setBackground(Config.INPUT_FIELD_FAIL_COLOR);
	}

	/**
	 * Resets the input field and background so that it can be edited again and
	 * the background color is back in the state indicating that it the user has
	 * not yet failed.
	 */
	public void reset() {
		this.setBackground(Config.INPUT_FIELD_IN_PROGRESS_COLOR);
		this.setEditable(true);
	}

}
