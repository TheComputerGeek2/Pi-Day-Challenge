package main;

import gui.UserInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {

	public static File PI_FILE;
	
	public static void main(String[] args) {
		getFile();
		new UserInterface();
	}
	
	public static void getFile() {
		try {
		
		File piData = new File("Pi.txt");
		if (!piData.exists()) {
			URL website = new URL("https://dl.dropboxusercontent.com/u/44791770/Pi.txt");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			piData.createNewFile();
			FileOutputStream fos = new FileOutputStream(piData);
			
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.flush();
			fos.close();
		
		}
		
		Main.PI_FILE = piData;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
