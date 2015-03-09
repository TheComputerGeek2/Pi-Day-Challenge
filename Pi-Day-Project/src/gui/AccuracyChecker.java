package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import main.Main;

import performance.UserAttempt;

public class AccuracyChecker {

	private static PiInputField inputField;

	private static int digitIndex;

	private static Scanner piReader;

	private static int actualNextDigit;

	private static boolean lastDigitCorrect;

	private static File piDigits;

	private static UserAttempt previousAttempt;

	private static UserAttempt currentAttempt;

	/**
	 * Creates a new AccuracyChecker to verify that the user is entering the
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
	 * Retrieves the UserAttempt object for the latest user attempt.
	 * 
	 * @return the UserAttempt object.
	 */
	public static UserAttempt getCurrentUserAttempt() {
		return AccuracyChecker.currentAttempt;
	}

	/**
	 * Returns the UserAttempt object for the previous attempt.
	 * 
	 * @return the previous attempt.
	 */
	public static UserAttempt getPreviousUserAttempt() {
		return AccuracyChecker.previousAttempt;
	}

	/**
	 * Indicates that the attempt has started. Instantiates a new UserAttempt
	 * object and applies the passed value as the start time.
	 * 
	 * @param time
	 *            the time the attempt started.
	 */
	public static void startAttempt(long time) {
		AccuracyChecker.currentAttempt = new UserAttempt();
		AccuracyChecker.currentAttempt.setStartTime(time);
	}

	/**
	 * Indicates that this attempt should be marked with its ending data and
	 * applies the passed values. Uses the default username value.
	 * 
	 * @param time
	 *            the time the attempt ended.
	 * @param reason
	 *            the reason the attempt ended.
	 */
	public static void endAttempt(long time, String reason) {
		AccuracyChecker.endAttempt(time, reason, UserAttempt.DEFAULT_USERNAME);
	}

	/**
	 * Indicates that this attempt should be marked with its ending data and
	 * applies the passed values.
	 * 
	 * @param time
	 *            the time the attempt ended.
	 * @param reason
	 *            the reason the attempt ended.
	 * @param username
	 *            the user's name.
	 */
	public static void endAttempt(long time, String reason, String username) {
		AccuracyChecker.currentAttempt.setEndTime(time);
		AccuracyChecker.currentAttempt.setEndReason(reason);
		AccuracyChecker.currentAttempt.setDigitsCorrect(AccuracyChecker
				.getDigitsCorrect());
		AccuracyChecker.currentAttempt.setUsername(username);
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

		AccuracyChecker.previousAttempt = AccuracyChecker.currentAttempt;

	}

	/**
	 * returns the number of digits the user has gotten correct so far.
	 * 
	 * @return the number of correct digits.
	 */
	public static int getDigitsCorrect() {
		int temp = AccuracyChecker.digitIndex;
		if (!AccuracyChecker.lastDigitCorrect) {
			temp--;
		}
		return temp;
	}

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
	 *            the user's text input.
	 * 
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

		int userValue = Integer.parseInt(String.valueOf(userText
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