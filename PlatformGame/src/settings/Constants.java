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
	// 1 second in nanoseconds / required FPS
	public static final double GAME_UPS = 1000000000 / 1000; // updates per second
	public static final double GAME_FPS = 1000000000 / 60; // frames per second (graphics)

	public static final int GAME_TICK_SPEED = 1;
	public static final double SPEED_INCREMENT = 0.003;
	public static final double SPEED_DECREMENT = 0.001;
	public static final double MAX_WALK_SPEED = 0.1;
	public static final double MAX_RUN_SPEED = 0.3;
	public static final double GRAVITY = 0.00125;
	public static final double JUMP_SPEED = 0.3;
	public static final double MAX_FALL_SPEED = 0.3;

	public static final boolean DEBUG_MODE = false;
}