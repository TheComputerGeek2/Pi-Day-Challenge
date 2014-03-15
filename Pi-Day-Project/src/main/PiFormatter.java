package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PiFormatter {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner unformattedInput = new Scanner(
				new File(
						"C:\\Users\\ros_sjdixon002\\workspace\\Pi Day\\src\\main\\Pi.txt"));
		PrintStream piOut = new PrintStream(
				new File(
						"C:\\Users\\ros_sjdixon002\\workspace\\Pi Day\\src\\main\\Pi2.txt"));
		while (unformattedInput.hasNext()) {
			String temp = unformattedInput.next();
			char[] charSet = temp.toCharArray();
			for (char c : charSet) {
				piOut.print(c + " ");
			}
			piOut.println();

		}
	}
}
