package settings;

public class Constants {
	public static final int TILE_SIZE = 16;
	public static final int SPRITE_SIZE_X = 50;
	public static final int SPRITE_SIZE_Y = 37;
	public static final int GAME_RESOLUTION_X = 480;
	public static final int GAME_RESOLUTION_Y = 270; // will eventually be the game at 240 with a 30px banner
	public static int FRAME_RESOLUTION_X = GAME_RESOLUTION_X;
	public static int FRAME_RESOLUTION_Y = GAME_RESOLUTION_Y;

	public static final double GAME_UPS = 1000; // updates per second
	public static final double GAME_FPS = 60; // frames per second (graphics)
	// 1 second in nanoseconds / required FPS
	public static final double DELTA_UPS = 1000000000 / GAME_UPS; // updates per second converted to nanosecond intervals
	public static final double DELTA_FPS = 1000000000 / GAME_FPS; // frames per second (graphics) converted to nanosecond intervals

	public static boolean DEBUG_MODE = false;
	
	public static void updateScreenResolution(int newFrameX, int newFrameY) {
		if (Constants.DEBUG_MODE) System.out.print("newFrame = " + newFrameX + ", " + newFrameY);
		int newX = GAME_RESOLUTION_X;
		int newY = GAME_RESOLUTION_Y;

	    // if game resolution is smaller than the frame, double until it's larger, then we will reduce size to fit
	    while (newX < newFrameX || newY < newFrameY ) {
	    	newX *= 2;
	    	newY *= 2;
	    }
	    if (Constants.DEBUG_MODE) System.out.print(", newSize = " + newX + ", " + newY);
	    
	    // first check if width is too big and needs scaling
	    if (newX > newFrameX) {
	    	if (Constants.DEBUG_MODE) System.out.print(", scalingX");
	        //scale width to fit
	    	newX = newFrameX;
	        //scale height to maintain aspect ratio
	    	newY = (int)(newX * ((double)GAME_RESOLUTION_Y / GAME_RESOLUTION_X));
	    }
	    // first check if width is too big and needs scaling
	    if (newY > newFrameY) {
	    	if (Constants.DEBUG_MODE) System.out.print(", scalingY");
	        //scale width to fit
	    	newY = newFrameY;
	        //scale height to maintain aspect ratio
	    	newX = (int)(newY * ((double)GAME_RESOLUTION_X / GAME_RESOLUTION_Y));
	    }

	    //FRAME_RESOLUTION_X = newX;
	    //FRAME_RESOLUTION_Y = newY;
		if (Constants.DEBUG_MODE) System.out.println(", new, " + newX + ", " + newY);

	}
}