package settings;

import java.awt.Toolkit;

public class Constants {
	public static final int TILE_SIZE = 16;
	public static final int SPRITE_SIZE_X = 50;
	public static final int SPRITE_SIZE_Y = 37;
	public static final int GAME_RESOLUTION_X = 320;
	public static final int GAME_RESOLUTION_Y = 160;
	public static final int SCREEN_RESOLUTION_X = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int SCREEN_RESOLUTION_Y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final double SIZE_MULTIPLIER = (SCREEN_RESOLUTION_X / GAME_RESOLUTION_X);

	public static final double GAME_UPS = 1000; // updates per second
	public static final double GAME_FPS = 60; // frames per second (graphics)
	// 1 second in nanoseconds / required FPS
	public static final double DELTA_UPS = 1000000000 / GAME_UPS; // updates per second converted to nanosecond intervals
	public static final double DELTA_FPS = 1000000000 / GAME_FPS; // frames per second (graphics) converted to nanosecond intervals

	public static final boolean DEBUG_MODE = false;
}