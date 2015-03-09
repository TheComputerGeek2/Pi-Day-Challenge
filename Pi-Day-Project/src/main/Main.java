package main;

import gui.AccuracyChecker;
import gui.UserInterface;

import java.io.File;

public class Main {

	public static File PI_FILE;
	
	public static void main(String[] args) {
		AccuracyChecker.getFile();
		new UserInterface();
	}
}
