package gui;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Config;
import performance.AttemptLogger;

public class PiInputField extends JTextField implements KeyListener {

	/**
	 * Represents the file that contains the digits of pi. This should be fixed
	 * later.
	 */
	public static final String PI_FILE = "W:\\Staff_Student\\jjmiller\\Writeable\\Pi.txt";

	private static boolean hasFailed = false;

	private AccuracyChecker ac;

	private static String endTime;

	private static String startTime;

	private static boolean hasStarted = false;

	/**
	 * Instantiates the default input field for the gui. Loads with the
	 * listeners ready and the font set.
	 */
	public PiInputField() {
		super();
		this.ac = new AccuracyChecker(this, new File(PiInputField.PI_FILE));
		this.addKeyListener(this);
		this.setFont(Config.INPUT_FONT);
		this.setBackground(Config.INPUT_FIELD_IN_PROGRESS_COLOR);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (!PiInputField.hasStarted) {
			long startTime = System.currentTimeMillis();
			PiInputField.startTime = new Date(startTime).toString();
			System.out.println("Start time has been set to: "
					+ PiInputField.startTime);
		}
		PiInputField.hasStarted = true;
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
		long failTime = System.currentTimeMillis();
		PiInputField.endTime = new Date(failTime).toString();
		System.out.println("Fail time is now set to: " + PiInputField.endTime);
		this.setEditable(false);
		PiInputField.hasFailed = true;
		this.setBackground(Config.INPUT_FIELD_FAIL_COLOR);
	}

	/**
	 * Resets the input field and background so that it can be edited again and
	 * the background color is back in the state indicating that it the user has
	 * not yet failed.
	 */
	public void reset() {
		if (PiInputField.hasFailed) {
			printAttempt();
		}
		PiInputField.hasFailed = false;
		this.setBackground(Config.INPUT_FIELD_IN_PROGRESS_COLOR);
		PiInputField.hasStarted = false;
		this.setEditable(true);
	}

	private String getUsername() {
		String username = JOptionPane.showInputDialog("Please input your name");
		return username;
	}

	private String getStartTime() {
		return PiInputField.startTime;
	}

	private String getEndTime() {
		return PiInputField.endTime;
	}

	private int getDigitCount() {
		return AccuracyChecker.getDigitsCorrect();
	}

	private void printAttempt() {
		AttemptLogger.logAttempt(getUsername(), getStartTime(), getEndTime(),
				getDigitCount());
	}
}
