package gui;

import java.awt.Font;

import javax.swing.JFrame;

public class FontManager {

	private static JFrame frame;

	public FontManager(JFrame baseFrame) {
		FontManager.frame = baseFrame;

	}

	/**
	 * Returns a font appropriate for the digit display component based upon the
	 * frame size.
	 * 
	 * @return the font to apply
	 */
	public static Font getDigitDisplayFont() {
		// TODO calculate a font for the digit display
		return null;
	}

	/**
	 * Returns a font appropriate for the digit input component based upon the
	 * frame size.
	 * 
	 * @return the font to apply
	 */
	public static Font getDigitInputFont() {
		// TODO calculate a font for the digit input component
		return null;
	}

	/**
	 * Returns a font appropriate for the ranking display component based upon
	 * the frame size.
	 * 
	 * @return the font to apply
	 */
	public static Font getRankingDisplayFont() {
		// TODO calculate a font for the ranking display
		return null;
	}

}
