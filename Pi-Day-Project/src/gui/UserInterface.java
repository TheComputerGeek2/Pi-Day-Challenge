package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Config;
import main.DimensionsProcessor;

/**
 * A container for the main user interface layout of the application.
 * 
 * @author TheComputerGeek2
 */
public class UserInterface {

	private JFrame frame;

	private static DigitDisplay display;

	private PiInputField input;

	private static RankingDisplay ranking;

	/**
	 * The title to be used for most frames in the application.
	 * <p>
	 * Value: {@value}
	 */
	public static final String FRAME_TITLE = "Pi Day Challenge"; //$NON-NLS-1$

	
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
		panel.add(UserInterface.makePreviousDigitsDisplay());
		input = new PiInputField();
		panel.add(input);
		this.frame.add(panel, BorderLayout.CENTER);
	}

	private void addRankingDisplay() {
		UserInterface.ranking = new RankingDisplay();
		this.frame.add(UserInterface.ranking, BorderLayout.EAST);

		// TODO add this when everything else is working
	}

	private static JTextArea makePreviousDigitsDisplay() {
		UserInterface.display = new DigitDisplay();
		return UserInterface.display;

	}

	private void makeFrame() {
		this.frame = new JFrame();
		this.frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
		this.frame.setTitle(UserInterface.FRAME_TITLE);
	}

	public static DigitDisplay getDigitDisplay() {
		return UserInterface.display;
	}
	
	public static RankingDisplay getRankingDisplay() {
		return UserInterface.ranking;
	}

}