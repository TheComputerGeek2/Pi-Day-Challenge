package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DimensionsProcessor {

	private int baseWidth;
	private int baseHeight;

	private double scale;

	public DimensionsProcessor(int baseWidth, int baseHeight) {
		this.baseWidth = baseWidth;
		this.baseHeight = baseHeight;
		determineScale();
	}

	private void determineScale() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.scale = (Math.min((screensize.getWidth() / this.baseWidth),
				(screensize.getHeight() / this.baseHeight)));
	}

	/**
	 * <strong>getScale</strong>
	 * <p>
	 * public double <strong>getScale</strong>()
	 * <p>
	 * 
	 * Finds the maximum value that the dimensions can be multiplied by while
	 * still keeping the aspect ratio.
	 * 
	 * @return the scale factor.
	 */
	public double getScale() {
		return this.scale;
	}

	/**
	 * <strong>centerFrame</strong>
	 * <p>
	 * public static void <strong>centerFrame</strong>({@link JFrame} frame)
	 * <p>
	 * 
	 * Centers the frame passed on the monitor.
	 * 
	 * @param frame
	 *            the frame to center.
	 */
	public static void centerFrame(JFrame frame) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

		int newX = (screensize.width / 2) - (frame.getWidth() / 2);
		int newY = (screensize.height / 2) - (frame.getHeight() / 2);
		frame.setLocation(newX, newY);

	}
}
