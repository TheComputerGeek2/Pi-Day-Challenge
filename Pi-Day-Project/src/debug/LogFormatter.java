package debug;

public class LogFormatter {

	public static enum Flags {
		;
		/**
		 * A flag value to indicate that the importance of this print is at an
		 * info level.
		 */
		public static final String IMPORTANCE_INFO = "Info";

		/**
		 * A flag value to indicate that the importance of this print is at a
		 * warning level.
		 */
		public static final String IMPORTANCE_WARNING = "Warning";

		/**
		 * A flag value to indicate that the importance of this print is high
		 * and likely a severe issue.
		 */
		public static final String IMPORTANCE_SEVERE = "Severe";

		/**
		 * A flag value to indicate that this print is coming from the accuracy
		 * checker.
		 */
		public static final String SOURCE_ACCURACY_CHECKER = "Accuracy Checker";

		/**
		 * A flag value to indicate that this print is coming from the Pi Input
		 * Field.
		 */
		public static final String SOURCE_PI_INPUT_FIELD = "Pi Input Field";

		/**
		 * A flag value to indicate that this print is coming from the user
		 * interface.
		 */
		public static final String SOURCE_USER_INTERFACE = "User Interface";

		/**
		 * A flag value to indicate that this print is about a user input.
		 */
		public static final String TYPE_USER_INPUT = "User Input";

		/**
		 * A flag value to indicate that this is about an event.
		 */
		public static final String TYPE_EVENT = "Event";

	}

	/**
	 * Adds flags onto the provided text value in a nice format.
	 * 
	 * @param text
	 *            the base text value.
	 * @param flags
	 *            the flags to apply.
	 * @return the string with the base text and flags applied.
	 */
	public static String addFlags(String text, String[] flags) {
		String temp = text;
		if (flags == null) {
			return text;
		}
		if (flags.length == 0) {
			return text;
		}

		for (String s : flags) {
			temp += generateFlagString(s);
		}

		return temp;
	}

	/**
	 * Adds a single flag to the passed based value.
	 * 
	 * @param value
	 *            the base string.
	 * @param flag
	 *            the flag to add to it.
	 * @return the string with the flag added in proper format.
	 */
	public static String addFlag(String value, String flag) {
		return value + generateFlagString(flag);
	}

	private static String generateFlagString(String flagValue) {
		if (flagValue == null) {
			return ""; //$NON-NLS-1$
		}
		if (flagValue.equals("")) { //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
		return "[" + flagValue + "]"; //$NON-NLS-1$//$NON-NLS-2$
	}

}
