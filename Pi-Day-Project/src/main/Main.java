package main;

import gui.UserInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

public class Main {

	public static File PI_FILE;

	private static boolean DEBUG = false;

	private static PrintStream debugOut = System.out;

	private static String piFileName = "Pi.txt";

	public static void main(String[] args) {
		if (args.length >= 1) {
			Main.DEBUG = Boolean.parseBoolean(args[0]);
		}
		getFile();
		new UserInterface();
	}

	/**
	 * <strong>debugPrintln</strong>
	 * <p>
	 * public static void <strong>debugPrintln</strong>({@link String} s)
	 * <p>
	 * 
	 * Writes s to the debug PrintStream, if the debug mode has been enabled.
	 * 
	 * @param s
	 *            the value to write to the debug stream.
	 */
	public static void debugPrintln(String s) {
		if (DEBUG) {
			debugOut.println(s);
		}
	}

	/**
	 * <strong>debugException</strong>
	 * <p>
	 * public static void <strong>debugException</strong>({@link Exception} e)
	 * <p>
	 * 
	 * Writes e's stack trace to the debug PrintStream.
	 * 
	 * @param e
	 *            the Exception to write to the debug stream.
	 */
	public static void debugException(Exception e) {
		e.printStackTrace(debugOut);
	}

	/**
	 * <strong>getFile</strong>
	 * <p>
	 * public static void <strong>getFile</strong>()
	 * <p>
	 * 
	 * Ensures that there is a file with the digits of Pi that the application
	 * may read from. Downloads the file if it isn't found locally.
	 * 
	 */
	public static void getFile() {
		try {

			File piData = new File(piFileName);
			if (!piData.exists()) {

				URL website = new URL(
						"https://dl.dropboxusercontent.com/u/44791770/Pi.txt");
				ReadableByteChannel rbc = Channels.newChannel(website
						.openStream());
				piData.createNewFile();
				FileOutputStream fos = new FileOutputStream(piData);

				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.flush();
				fos.close();

			}

			Main.PI_FILE = piData;

		} catch (IOException e) {
			// TODO handle this nicely
			showErrorMessage(
					"Something prevented the loading of the Pi.txt file.\n",
					"If problem occurrs again,\n",
					"run with debug mode enabled launching with:\n",
					"java -jar PiDay.jar true");

			Main.debugException(e);

			System.exit(1);
		}
	}

	public static void showErrorMessage(String... message) {

		JOptionPane.showMessageDialog(null, mergeStrings(message),
				UserInterface.FRAME_TITLE, JOptionPane.ERROR_MESSAGE);
	}

	private static String mergeStrings(String... strings) {
		String combined = "";
		for (String s : strings) {
			combined += s;
		}

		return combined;
	}

	public static void fatalErrorNotification() {
		showErrorMessage("Fatal error encountered, unable to proceed.\n",
				"Application will now shut down.");
		System.exit(1);
	}

}
