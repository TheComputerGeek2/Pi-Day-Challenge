package performance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;

public class AttemptLogger {

	private static final String ATTEMPT_LOG_FOLDER = ""; // This should be the
															// directory where
															// the
															// attempt logs are
															// saved

	/**
	 * The name of the current attempt log file to write to.
	 */
	private static String currentAttemptLog;

	private static PrintStream out = System.out; // TODO change this to it
													// prints to the attempt
													// file

	public AttemptLogger() {
		try {
			createNewAttemptFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Creates a new file to save the attempts
	 * 
	 * @throws FileNotFoundException
	 *             thrown by the PrintStream
	 * 
	 */
	private static void createNewAttemptFile() throws FileNotFoundException {
		if (AttemptLogger.out != null) {
			AttemptLogger.out.close();
		}
		AttemptLogger.currentAttemptLog = createLogName();
		AttemptLogger.out = new PrintStream(new File(
				AttemptLogger.currentAttemptLog));

	}

	/**
	 * Returns a name for a new attempt log file.
	 * 
	 * @return the new file name.
	 */
	private static String createLogName() {
		return "Pi-Attempt-Log-Of-" + (new Date(System.currentTimeMillis()).toString()) + ".txt"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Logs an attempt to the attempt log.
	 * 
	 * @param username
	 *            the user's name
	 * @param startTime
	 *            the time the attempt started.
	 * @param endTime
	 *            the time the attempt was finished.
	 * @param digits
	 *            the number of digits the user got correct.
	 */
	public static void logAttempt(String username, String startTime,
			String endTime, int digits) {
		// TODO print the passed data into the current log
		AttemptLogger.out.println("Username: " + username);
		AttemptLogger.out.println("Start Time: " + startTime);
		AttemptLogger.out.println("End Time: " + endTime);
		AttemptLogger.out.println("Digits correct: " + digits);
		AttemptLogger.out.println();
	}

	/**
	 * Logs the user's attempt from the UserAttempt object.
	 * 
	 * @param attempt
	 *            the object containing the user's attempt.
	 */
	public static void logAttempt(UserAttempt attempt) {
		AttemptLogger.out.println(attempt.toString());
		AttemptLogger.out.println();
	}
}
