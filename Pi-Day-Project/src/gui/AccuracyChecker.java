package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class AccuracyChecker {

	private static PiInputField inputField;

	private static int digitIndex;

	private static Scanner piReader;

	private static int actualNextDigit;

	private static boolean lastDigitCorrect;

	private static File piDigits;

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
	public AccuracyChecker(PiInputField inputField, File piDigits) {
		AccuracyChecker.piDigits = piDigits;
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
		AccuracyChecker.inputField.setText(""); //$NON-NLS-1$
		AccuracyChecker.actualNextDigit = AccuracyChecker.piReader.nextInt();
		AccuracyChecker.lastDigitCorrect = true;
	}

	/**
	 * Resets the accuracy checker and the input field for next usage.
	 */
	public static void reload() {
		AccuracyChecker.piReader.close();
		try {
			AccuracyChecker.piReader = new Scanner(AccuracyChecker.piDigits);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		AccuracyChecker.digitIndex = 0;
		AccuracyChecker.inputField.setText(null);
		AccuracyChecker.actualNextDigit = AccuracyChecker.piReader.nextInt();
		AccuracyChecker.lastDigitCorrect = true;
		AccuracyChecker.inputField.reset();

	}

	/**
	 * returns the number of digits the user has gotten correct so far.
	 * 
	 * @return the number of correct digits
	 */
	public static int getDigitsCorrect() {
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
	/*
	 * public static boolean checkNextDigit() {
	 * 
	 * if (AccuracyChecker.inputField.getText().length() ==
	 * AccuracyChecker.digitIndex) { int userValue =
	 * AccuracyChecker.inputField.getText().charAt(
	 * AccuracyChecker.inputField.getText().length() - 1);
	 * 
	 * System.out.println("User's value is: " + userValue); int actualValue =
	 * AccuracyChecker.piReader.nextInt(); System.out.println("Actual Value: " +
	 * actualValue); boolean isRight = (userValue == actualValue); if (isRight)
	 * { AccuracyChecker.digitIndex++; } AccuracyChecker.lastDigitCorrect =
	 * isRight; return false; } else { return true; } }
	 */

	/**
	 * Checks if a new character has been entered to be checked.
	 * 
	 * @param userText
	 *            the text in the input field.
	 * @return if there is a new character to check.
	 */
	private static boolean hasNewCharacter(String userText) {
		System.out.println("Checking for new character in string " + userText);
		System.out.println("Digit index is " + AccuracyChecker.digitIndex);
		return (userText.length() > AccuracyChecker.digitIndex);

	}

	private static void updateDigitCheck() {
		AccuracyChecker.digitIndex++;
		AccuracyChecker.actualNextDigit = AccuracyChecker.piReader.nextInt();
	}

	/**
	 * Checks if the character at the current digit index is valid.
	 * 
	 * @param userText
	 *            the user's text input
	 * @return if it is a valid character.
	 */
	private static boolean isCurrentCharacterValid(String userText) {
		return (!"0123456789".contains(String.valueOf(userText
				.charAt(AccuracyChecker.digitIndex))));
	}

	public static boolean checkNextDigit(String userText) {
		if (!AccuracyChecker.hasNewCharacter(userText)) {
			System.out.println("No new characters found");
			return true;
		}
		/*
		 * if (!isCurrentCharacterValid(userText)) {
		 * System.out.println("User input is not valid: " + userText);
		 * System.out.println("Digit index is " + AccuracyChecker.digitIndex);
		 * return false; }
		 */

		int userValue = Integer.valueOf(String.valueOf(userText
				.charAt(digitIndex)));
		System.out.println("User value is " + userValue);
		boolean isRight = (userValue == AccuracyChecker.actualNextDigit);
		System.out
				.println("Actual value is " + AccuracyChecker.actualNextDigit);
		System.out.println("Is the user right? " + isRight);
		AccuracyChecker.digitIndex++;
		System.out.println("Changing digit index to "
				+ AccuracyChecker.digitIndex);
		AccuracyChecker.actualNextDigit = AccuracyChecker.piReader.nextInt();
		System.out.println("Next correct digit: "
				+ AccuracyChecker.actualNextDigit);
		if (isRight) {
			UserInterface.getDigitDisplay().updateDisplay(
					String.valueOf(AccuracyChecker.digitIndex));
		}
		return isRight;

	}
}