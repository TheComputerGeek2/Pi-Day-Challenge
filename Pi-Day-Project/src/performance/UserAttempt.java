package performance;

import java.util.Date;

/**
 * A class that holds data for various user attempts.
 */
public class UserAttempt {

	/**
	 * An enumeration containing the various reasons that the attempt could have
	 * been ended.
	 */
	public static enum EndReason {
		;

		/**
		 * A value to indicate that the attempt ended because the user got a
		 * digit wrong.
		 * 
		 * <p>
		 * Value: {@value}
		 */
		public static final String WRONG_DIGIT = "Wrong Digit"; //$NON-NLS-1$

		/**
		 * A value to indicate that the user manually restarted the attempt.
		 * <p>
		 * Value: {@value}
		 */
		public static final String MANUAL_RESTART = "Manual Restart"; //$NON-NLS-1$

		/**
		 * A value to indicate an unknown reason for the attempt ending.
		 * <p>
		 * Value: {@value}
		 */
		public static final String UNSPECIFIED = "Unknown Reason"; //$NON-NLS-1$
	}

	/**
	 * A default name to give a user if they don't specify their's.
	 * <p>
	 * Value: {@value}
	 */
	public static final String DEFAULT_USERNAME = "Unspecified";

	private String username = UserAttempt.DEFAULT_USERNAME; //$NON-NLS-1$

	private String startTime = "unknown"; //$NON-NLS-1$

	private String endTime = "unknown"; //$NON-NLS-1$

	private String endReason = EndReason.UNSPECIFIED;

	private int digitsCorrect = -1;

	/**
	 * <strong>UserAttempt</strong>
	 * <p>
	 * public <strong>UserAttempt</strong>()
	 * <p>
	 * 
	 * Creates a new UserAttempt object with the default data.
	 */
	public UserAttempt() {

	}

	/**
	 * <strong>UserAttempt</strong>
	 * <p>
	 * public <strong>UserAttempt</strong>(String username, String startTime,
	 * String endTime, int digitsCorrect, String endReason)
	 * <p>
	 * 
	 * Creates a new object to represent a user attempt with the specified data.
	 * 
	 * @param username
	 *            the user's name.
	 * 
	 * @param startTime
	 *            the attempt start time.
	 * 
	 * @param endTime
	 *            the attempt end time.
	 * 
	 * @param digitsCorrect
	 *            the number of digits correct on this attempt.
	 * 
	 * @param endReason
	 *            the reason this attempt ended.
	 */
	public UserAttempt(String username, String startTime, String endTime,
			int digitsCorrect, String endReason) {
		this.username = username;
		this.startTime = startTime;
		this.endTime = endTime;
		this.digitsCorrect = digitsCorrect;
		this.endReason = endReason;
	}

	/**
	 * <strong>getUsername</strong>
	 * <p>
	 * public String <strong>getUsername</strong>()
	 * <p>
	 * 
	 * Returns the username associated with this attempt.
	 * 
	 * @return the username.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * <strong>getStartTime</strong>
	 * <p>
	 * public String <strong>getStartTime</strong>()
	 * <p>
	 * 
	 * Returns the start time associated with this attempt.
	 * 
	 * @return the start time.
	 */
	public String getStartTime() {
		return this.startTime;
	}

	/**
	 * <strong>getEndTime</strong>
	 * <p>
	 * public String <strong>getEndTime</strong>()
	 * <p>
	 * 
	 * Returns the end time associated with this attempt.
	 * 
	 * @return the end time.
	 */
	public String getEndTime() {
		return this.endTime;
	}

	/**
	 * <strong>getEndReason</strong>
	 * <p>
	 * public String <strong>getEndReason</strong>()
	 * <p>
	 * 
	 * Returns the apparent reason for this attempt being ended.
	 * 
	 * @return the end reason.
	 */
	public String getEndReason() {
		return this.endReason;
	}

	/**
	 * <strong>getDigitsCorrect</strong>
	 * <p>
	 * public int <strong>getDigitsCorrect</strong>()
	 * <p>
	 * 
	 * Returns the number of digits the user got correct on this attempt.
	 * 
	 * @return the number of digits correct.
	 */
	public int getDigitsCorrect() {
		return this.digitsCorrect;
	}

	/**
	 * <strong>setStartTime</strong>
	 * <p>
	 * public void <strong>setStartTime</strong>(long startTime)
	 * <p>
	 * 
	 * Sets the start time to associate with this attempt.
	 * 
	 * @param startTime
	 *            the start time to list.
	 */
	public void setStartTime(long startTime) {
		this.startTime = new Date(startTime).toString();
	}

	/**
	 * <strong>setStartTime</strong>
	 * <p>
	 * public void <strong>setStartTime</strong>(String startTime)
	 * <p>
	 * 
	 * Sets the start time to associate with this attempt.
	 * 
	 * @param startTime
	 *            the start time to list.
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * <strong>setUsername</strong>
	 * <p>
	 * public void <strong>setUsername</strong>(String username)
	 * <p>
	 * 
	 * Sets the username to associate with this attempt.
	 * 
	 * @param username
	 *            the user's name.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * <strong>setEndTime</strong>
	 * <p>
	 * public void <strong>setEndTime</strong>(long endTime)
	 * <p>
	 * 
	 * Sets the time that this attempt ended.
	 * 
	 * @param endTime
	 *            when the attempt ended.
	 */
	public void setEndTime(long endTime) {
		this.endTime = new Date(endTime).toString();
	}

	/**
	 * <strong>setEndTime</strong>
	 * <p>
	 * public void <strong>setEndTime</strong>(String endTime)
	 * <p>
	 * 
	 * Sets the time that this attempt ended.
	 * 
	 * @param endTime
	 *            when the attempt ended.
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * <strong>setEndReason</strong>
	 * <p>
	 * public void <strong>setEndReason</strong>(String reason)
	 * <p>
	 * 
	 * Specifies the reason this attempt ended.
	 * 
	 * @param reason
	 *            why the attempt ended.
	 */
	public void setEndReason(String reason) {
		this.endReason = reason;
	}

	/**
	 * <strong>setDigitsCorrect</strong>
	 * <p>
	 * public void <strong>setDigitsCorrect</strong>(int digits)
	 * <p>
	 * 
	 * Specifies how many digits the user got correct.
	 * 
	 * @param digits
	 *            the number they got right
	 */
	public void setDigitsCorrect(int digits) {
		this.digitsCorrect = digits;
	}

	/**
	 * <strong>toString</strong>
	 * <p>
	 * public String <strong>toString</strong>()
	 * <p>
	 * 
	 * Returns the string equivalent of this object. Each element is on its own
	 * line.
	 * <p />
	 * The elements in order are: <br>
	 * <li>the username <br>
	 * <li>the start time <br>
	 * <li>the end time <br>
	 * <li>the number of digits correct <br>
	 * <li>the end reason <br>
	 * 
	 * @return the String representation of this attempt
	 */
	@Override
	public String toString() {
		return this.username + "\n" + this.startTime + "\n" + this.endTime //$NON-NLS-1$ //$NON-NLS-2$
				+ "\n" + this.digitsCorrect + "\n" + this.endReason; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * <strong>toStrings</strong>
	 * <p>
	 * public String[] <strong>toStrings</strong>()
	 * <p>
	 * 
	 * Creates a serialized form of the user attempt stored in a string array.
	 * <p>
	 * Can be recovered using {@link #loadFromStrings(String[])}
	 * 
	 * @return a serialized form of the attempt.
	 * 
	 * @see #loadFromStrings(String[])
	 */
	public String[] toStrings() {
		return new String[] { this.username, this.startTime, this.endTime,
				Integer.toString(this.digitsCorrect), this.endReason };
	}

	/**
	 * <strong>loadFromStrings</strong>
	 * <p>
	 * public static UserAttempt <strong>loadFromStrings</strong>(String[]
	 * attemptData)
	 * <p>
	 * 
	 * Returns a UserAttempt object representing an attempt from the data stored
	 * in the passed data.
	 * <p>
	 * The data elements, in order are:
	 * <li>The user's name <br>
	 * <li>The starting time of the attempt. <br>
	 * <li>The end time of the attempt. <br>
	 * <li>The number of digits correct. <br>
	 * <li>The reason this attempt ended. <br>
	 * 
	 * 
	 * @param attemptData
	 *            the attempt data to load.
	 * 
	 * @return the UserAttempt object created from the data.
	 * 
	 * @throws IllegalArgumentException
	 *             if attemptData does not contain at least 5 elements.
	 */
	public static UserAttempt loadFromStrings(String[] attemptData) {
		if (attemptData.length < 5) {
			throw new IllegalArgumentException(
					"Passed data did not contain the required number of elements."); //$NON-NLS-1$
		}
		return new UserAttempt(attemptData[0], attemptData[1], attemptData[2],
				Integer.parseInt(attemptData[3]), attemptData[4]);
	}
}
