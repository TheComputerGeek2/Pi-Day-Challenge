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

	public static void debugPrintln(String s) {
		if (DEBUG) {
			debugOut.println(s);
		}
	}

	public static void debugException(Exception e) {
		e.printStackTrace(debugOut);
	}

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
			JOptionPane.showMessageDialog(null,
					"Something prevented the loading of the Pi.txt file.\n"
							+ "If problem occurrs again,\n"
							+ "run with debug mode enabled launching with:\n"
							+ "java -jar PiDay.jar true",
							
					UserInterface.FRAME_TITLE, JOptionPane.ERROR_MESSAGE);
			Main.debugException(e);
			
			System.exit(1);
		}
	}
}
