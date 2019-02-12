package physics;

import player.Direction;

public class Physics {
	// gravity increases velocity of an object at 9.8 meters per second
	// example, after 3 seconds of free fall, an object will be travelling at 9.8 * 3 meters per second
	public static final double GRAVITY = metersToPixels(9.8);  
	
	// https://www.angio.net/personal/climb/speed
	// terminal velocity is around 320kph, or lying flat, 195kph, therefore I'm setting this in the middle at 257.5
	// 257.5kph converts to 71.527777777777800 mps
	public static final double TERMINAL_VELOCITY = metersToPixels(71.527777777777800);
	
	// https://en.wikipedia.org/wiki/Walking
	// Average walking speed is 5.32kph, which converts to 1.4777777777777800 mps
	private static final double PLAYER_HEIGHT_METERS = 1.7;
	private static final double PLAYER_HEIGHT_PIXELS = 30;
	public static final double MAX_WALK_SPEED = metersToPixels(1.4777777777777800);
	public static final double WALK_SPEED_ACCELERATION = MAX_WALK_SPEED * 2;
	
	// https://www.iamlivingit.com/running/average-human-running-speed
	// Average running speed is 13.62kph, which converts to 3.7833333333333300 mps
	private static final double MAX_RUN_SPEED = metersToPixels(3.7833333333333300);
	public static final double RUN_SPEED_ACCELERATION = MAX_RUN_SPEED * 2;

	public static final double FLOOR_FRICTION = WALK_SPEED_ACCELERATION * .75;

	public static final double JUMP_ACCELERATION = MAX_RUN_SPEED;

	
	private static final double WEIGHT = 0.0;
	
	private static double getGravity(double secondsElapsed) {
		return GRAVITY * secondsElapsed;
	}

	public static double addGravity(double velocity, double secondsElapsed) {
		double newVelocity = velocity + getGravity(secondsElapsed);
		return newVelocity > TERMINAL_VELOCITY ? TERMINAL_VELOCITY : newVelocity;
	}
	
	private static double getFriction(double secondsElapsed) {
		return FLOOR_FRICTION * secondsElapsed;
	}

	public static double addFriction(double speedX, double secondsElapsed) {
		if (speedX > 0) {
			speedX -= getFriction(secondsElapsed);
			if (speedX < 0) speedX = 0;
		} else if (speedX < 0) {
			speedX += getFriction(secondsElapsed);
			if (speedX > 0) speedX = 0;
		}
		return speedX;
	}


	private static double getWalkSpeed(double secondsElapsed) {
		return WALK_SPEED_ACCELERATION * secondsElapsed;
	}

	public static double addWalkSpeed(double speedX, double secondsElapsed, Direction direction) {
		if (direction == Direction.RIGHT) {
			speedX += getWalkSpeed(secondsElapsed);
		} else {
			speedX -= getWalkSpeed(secondsElapsed);
		}
		if (speedX > MAX_WALK_SPEED) speedX = MAX_WALK_SPEED;
		if (speedX < -MAX_WALK_SPEED) speedX = -MAX_WALK_SPEED;
		return speedX;
	}

	private static double getRunSpeed(double secondsElapsed) {
		return RUN_SPEED_ACCELERATION * secondsElapsed;
	}

	public static double addRunSpeed(double speedX, double secondsElapsed, Direction direction) {
		if (direction == Direction.RIGHT) {
			speedX += getRunSpeed(secondsElapsed);
		} else {
			speedX -= getRunSpeed(secondsElapsed);
		}
		if (speedX > MAX_RUN_SPEED) speedX = MAX_RUN_SPEED;
		if (speedX < -MAX_RUN_SPEED) speedX = -MAX_RUN_SPEED;
		return speedX;
	}

	public static double metersToPixels(double meters) {
		return (PLAYER_HEIGHT_METERS / PLAYER_HEIGHT_PIXELS) * meters;
	}

	public static double pixelsToMeters(double pixels) {
		return (PLAYER_HEIGHT_PIXELS / PLAYER_HEIGHT_METERS) * pixels;
	}

	
}
