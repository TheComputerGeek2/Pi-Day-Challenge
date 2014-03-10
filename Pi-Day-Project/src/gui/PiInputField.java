package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class PiInputField extends JTextField implements KeyListener {

	public PiInputField() {
		super();
	}

	// TODO make sure the user can't use the backspace key or any non digit keys
	// TODO fire an event when the user types a valid character for the
	// AccuracyChecker to verify

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}