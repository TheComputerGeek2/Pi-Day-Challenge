package gui;

import javax.swing.JFrame;

public class UserInterface {

	private JFrame frame;

	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	
	public UserInterface() {
		makeFrame();
		frame.setVisible(true);
	}
	
	private void makeFrame() {
		this.frame = new JFrame();
		frame.setSize(UserInterface.WIDTH, UserInterface.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}