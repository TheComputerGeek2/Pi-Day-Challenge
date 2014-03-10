package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTextField;

class AccuracyChecker {

	private static JTextField inputField;

	private static int digitIndex;

	private static Scanner piReader;

	private static boolean lastDigitCorrect;

	/**
	 * Creates a new AccuracyChecker to verify that the user is intering the
	 * correct digits.
	 * 
	 * @param inputField
	 *            the JTextField to watch for the user's input.
	 * @param piDigits
	 *            the File containing the digits of pi for checking the user's
	 *            input against.
	 */
	AccuracyChecker(JTextField inputField, File piDigits) {
		AccuracyChecker.inputField = inputField;
		AccuracyChecker.digitIndex = 0;
		if (AccuracyChecker.piReader != null) {
			AccuracyChecker.piReader.close();
		}
		try {
			AccuracyChecker.piReader = new Scanner(piDigits);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccuracyChecker.inputField.setText("");
		AccuracyChecker.lastDigitCorrect = true;
	}

	/**
	 * returns the number of digits the user has gotten correct so far.
	 * 
	 * @return the number of correct digits
	 */
	static int getDigitsCorrect() {
		int temp = AccuracyChecker.digitIndex;
		if (!AccuracyChecker.lastDigitCorrect) {
			temp--;
		}
		return temp;
	}

	/**
	 * Checks the last digit on the input field to see if it is accurate and
	 * advances the index count if it is accurate. If it is wrong, it will set
	 * its state to indicate that the last digit was wrong.
	 * 
	 * @return if the last digit from the user is correct.
	 */
	static boolean checkNextDigit() {
		int userValue = AccuracyChecker.inputField.getText().charAt(
				AccuracyChecker.inputField.getText().length());
		int actualValue = Integer.valueOf(AccuracyChecker.piReader
				.next("0123456789"));
		boolean isRight = (userValue == actualValue);
		if (isRight) {
			AccuracyChecker.digitIndex++;
		}
		AccuracyChecker.lastDigitCorrect = isRight;
		return false;
	}

}