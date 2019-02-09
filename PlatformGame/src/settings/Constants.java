package settings;

import java.awt.Toolkit;

public class Constants {
	public static final int TILE_SIZE = 16;
	public static final int SPRITE_SIZE_X = 50;
	public static final int SPRITE_SIZE_Y = 37;
	public static final int GAME_RESOLUTION_X = 240;
	public static final int GAME_RESOLUTION_Y = 128;
	public static final int SCREEN_RESOLUTION_X = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int SCREEN_RESOLUTION_Y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final double SIZE_MULTIPLIER = (SCREEN_RESOLUTION_X / GAME_RESOLUTION_X);

	public static final int GAME_TICK_SPEED = 10;
	public static final double SPEED_INCREMENT = 0.03;
	public static final double MAX_WALK_SPEED = 1;
	public static final double MAX_RUN_SPEED = 3;
	public static final double GRAVITY = 0.5;
	
}
