package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JTextField;

import main.Main;

public class PiInputField extends JTextField implements KeyListener {

	public static final String PI_FILE = "W:\\Staff_Student\\jjmiller\\Writeable\\Pi.txt";

	public PiInputField() {
		super();
		new AccuracyChecker(this, new File(PiInputField.PI_FILE));
		this.addKeyListener(this);
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, Main.INPUT_FONT_SIZE));
		this.setBackground(Color.YELLOW);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_F5) {
			AccuracyChecker.reload();
			System.out.println("Accuracy Checker is Reloading");
			return;
		}
		Toolkit.getDefaultToolkit().sync();
		boolean isRight = AccuracyChecker.checkNextDigit(this.getText());
		if (!isRight) {
			this.failSequence();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public void failSequence() {
		this.setEditable(false);
		this.setBackground(Color.RED);
	}

	public void reset() {
		this.setBackground(Color.YELLOW);
		this.setEditable(true);
	}

}