package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.DimensionsProcessor;

public class UserInterface {

	private JFrame frame;

	public static final int WIDTH = 300;
	public static final int HEIGHT = 400;

	private DigitDisplay display;

	private PiInputField input;

	private RankingDisplay ranking;

	public UserInterface() {
		makeFrame();
		addDigitDisplay();
		addRankingDisplay();
		DimensionsProcessor.centerFrame(this.frame);
		this.frame.setVisible(true);

	}

	private void addDigitDisplay() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(makePreviousDigitsDisplay());
		panel.add(makeInputField());
		this.frame.add(panel, BorderLayout.CENTER);
	}

	private void addRankingDisplay() {
		this.ranking = new RankingDisplay();
		this.frame.add(this.ranking, BorderLayout.EAST);

		// TODO add this when everything else is working
	}

	private JTextArea makePreviousDigitsDisplay() {
		return new DigitDisplay();

	}

	private JTextField makeInputField() {
		return new PiInputField();
	}

	private void makeFrame() {
		this.frame = new JFrame();
		this.frame.setSize(UserInterface.WIDTH, UserInterface.HEIGHT);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
	}

}