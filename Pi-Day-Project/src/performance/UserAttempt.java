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
		 */
		public static final String WRONG_DIGIT = "Wrong Digit"; //$NON-NLS-1$

		/**
		 * A value to indicate that the user manually restarted the attempt.
		 */
		public static final String MANUAL_RESTART = "Manual Restart"; //$NON-NLS-1$

		/**
		 * A value to indicate an unknown reason for the attempt ending.
		 */
		public static final String UNSPECIFIED = "Unknown Reason"; //$NON-NLS-1$
	}

	public static final String DEFAULT_USERNAME = "Unspecified";

	private String username = UserAttempt.DEFAULT_USERNAME; //$NON-NLS-1$

	private String startTime = "unknown"; //$NON-NLS-1$

	private String endTime = "unknown"; //$NON-NLS-1$

	private String endReason = EndReason.UNSPECIFIED;

	private int digitsCorrect = -1;

	/**
	 * Creates a new UserAttempt object with the default data.
	 */
	public UserAttempt() {

	}

	/**
	 * Creates a new object to represent a user attempt with the specified data.
	 * 
	 * @param username
	 *            the user's name.
	 * @param startTime
	 *            the attempt start time.
	 * @param endTime
	 *            the attempt end time.
	 * @param digitsCorrect
	 *            the number of digits correct on this attempt.
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
	 * Returns the username associated with this attempt.
	 * 
	 * @return the username.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Returns the start time associated with this attempt.
	 * 
	 * @return the start time.
	 */
	public String getStartTime() {
		return this.startTime;
	}

	/**
	 * Returns the end time associated with this attempt.
	 * 
	 * @return the end time.
	 */
	public String getEndTime() {
		return this.endTime;
	}

	/**
	 * Returns the apparent reason for this attempt being ended.
	 * 
	 * @return the end reason.
	 */
	public String getEndReason() {
		return this.endReason;
	}

	/**
	 * Returns the number of digits the user got correct on this attempt.
	 * 
	 * @return the number of digits correct.
	 */
	public int getDigitsCorrect() {
		return this.digitsCorrect;
	}

	/**
	 * Sets the start time to associate with this attempt.
	 * 
	 * @param startTime
	 *            the start time to list.
	 */
	public void setStartTime(long startTime) {
		this.startTime = new Date(startTime).toString();
	}

	/**
	 * Sets the start time to associate with this attempt.
	 * 
	 * @param startTime
	 *            the start time to list.
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Sets the username to associate with this attempt.
	 * 
	 * @param username
	 *            the user's name.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the time that this attempt ended.
	 * 
	 * @param endTime
	 *            when the attempt ended.
	 */
	public void setEndTime(long endTime) {
		this.endTime = new Date(endTime).toString();
	}

	/**
	 * Sets the time that this attempt ended.
	 * 
	 * @param endTime
	 *            when the attempt ended.
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * Specifies the reason this attempt ended.
	 * 
	 * @param reason
	 *            why the attempt ended.
	 */
	public void setEndReason(String reason) {
		this.endReason = reason;
	}

	/**
	 * Specifies how many digits the user got correct.
	 * 
	 * @param digits
	 *            the number they got right
	 */
	public void setDigitsCorrect(int digits) {
		this.digitsCorrect = digits;
	}

	/**
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
