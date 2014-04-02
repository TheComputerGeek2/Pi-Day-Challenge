package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class Config {
	public static final int INPUT_FONT_SIZE = 40;

	public static final int PROGRESS_FONT_SIZE = 60;

	public static final Font PROGRESS_FONT = new Font(Font.SANS_SERIF,
			Font.PLAIN, Config.PROGRESS_FONT_SIZE);

	public static final Font INPUT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN,
			Config.INPUT_FONT_SIZE);

	public static final int FRAME_WIDTH = 300;

	public static final int FRAME_HEIGHT = 400;

	public static final Color INPUT_FIELD_FAIL_COLOR = Color.RED;

	public static final Color INPUT_FIELD_IN_PROGRESS_COLOR = Color.YELLOW;

	public static final int RESTART_KEYCODE = KeyEvent.VK_F5;

}
