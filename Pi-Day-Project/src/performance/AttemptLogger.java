package performance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import main.Main;

public class AttemptLogger {

	private static final String ATTEMPT_LOG_FOLDER = "H:\\attempts\\"; // This
																		// should
																		// be
																		// the
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
			AttemptLogger.createNewAttemptFile();
		} catch (FileNotFoundException e) {
			Main.debugException(e);
			Main.fatalErrorNotification();
		}

	}

	/**
	 * <strong>createNewAttempt</strong>
	 * <p>
	 * private static void <strong>createNewAttempt</strong>() throws
	 * {@link FileNotFoundException}
	 * <p>
	 * 
	 * Creates a new file to save the attempts.
	 * 
	 * @throws FileNotFoundException
	 *             thrown by the PrintStream.
	 * 
	 */
	private static void createNewAttemptFile() throws FileNotFoundException {
		if (AttemptLogger.out != null && AttemptLogger.out != (System.out)) {
			AttemptLogger.out.close();
		}
		AttemptLogger.currentAttemptLog = AttemptLogger.createLogName();
		File logFile = new File(AttemptLogger.currentAttemptLog);
		try {
			logFile.createNewFile();
			Main.debugPrintln("Created log file");
		} catch (IOException e) {
			Main.debugPrintln("Couldn't create new file");
			// TODO handle this nicely instead of crashing
			Main.debugException(e);
		}
		AttemptLogger.out = new PrintStream(logFile);

	}

	/**
	 * <strong>createLogName</strong>
	 * <p>
	 * private static {@link String} <strong>createLogName</strong>()
	 * <p>
	 * 
	 * Returns a name for a new attempt log file.
	 * 
	 * @return the new file name.
	 */
	private static String createLogName() {
		return AttemptLogger.ATTEMPT_LOG_FOLDER
				+ "Pi-Attempt-Log-Of-"
				+ (new Date(System.currentTimeMillis()).toString().replace(".",
						" ").replace(":", "-")) + ".txt";
	}

	/**
	 * <strong>logAttempt</strong>
	 * <p>
	 * public static void <strong>logAttempt</strong>({@link String} username, {@link String}
	 * startTime, {@link String} endTime, int digits)
	 * <p>
	 * 
	 * Logs an attempt to the attempt log.
	 * 
	 * @param username
	 *            the user's name.
	 * 
	 * @param startTime
	 *            the time the attempt started.
	 * 
	 * @param endTime
	 *            the time the attempt was finished.
	 * 
	 * @param digits
	 *            the number of digits the user got correct.
	 */
	public static void logAttempt(String username, String startTime,
			String endTime, int digits) {
		// TODO print the passed data into the current log
		AttemptLogger.ensureLogFile();
		AttemptLogger.out.println("Username: " + username); //$NON-NLS-1$
		AttemptLogger.out.println("Start Time: " + startTime); //$NON-NLS-1$
		AttemptLogger.out.println("End Time: " + endTime); //$NON-NLS-1$
		AttemptLogger.out.println("Digits correct: " + digits); //$NON-NLS-1$
		AttemptLogger.out.println();
	}

	/**
	 * <strong>logAttempt</strong>
	 * <p>
	 * public static void <strong>logAttempt</strong>({@link UserAttempt} attempt)
	 * <p>
	 * 
	 * Logs the user's attempt from the UserAttempt object.
	 * 
	 * @param attempt
	 *            the object containing the user's attempt.
	 */
	public static void logAttempt(UserAttempt attempt) {
		AttemptLogger.ensureLogFile();
		// AttemptLogger.out.println(attempt.toString());
		String[] data = attempt.toStrings();
		for (String s : data) {
			AttemptLogger.out.println(s);
		}
		AttemptLogger.out.println();
	}

	private static void ensureLogFile() {
		if (AttemptLogger.currentAttemptLog == null) {
			try {
				AttemptLogger.createNewAttemptFile();
			} catch (FileNotFoundException e) {
				Main.debugException(e);
				Main.debugPrintln("Error being responded to: using default printstream");
				AttemptLogger.currentAttemptLog = "Console";
				AttemptLogger.out = System.out;

				Main.showErrorMessage(
						"An error occurred when creating the log file,\n",
						"using console instead");

			}
		}
	}
}
