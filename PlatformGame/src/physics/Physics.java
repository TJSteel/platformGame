package physics;

public class Physics {
	// gravity increases velocity of an object at 9.8 meters per second
	// example, after 3 seconds of free fall, an object will be travelling at 9.8 * 3 meters per second
	private final double GRAVITY = 9.8;  
	
	// https://www.angio.net/personal/climb/speed
	// terminal velocity is around 320kph, or lying flat, 195kph, therefore I'm setting this in the middle at 257.5
	// 257.5kph converts to 71.527777777777800 mps
	private final double TERMINAL_VELOCITY = 71.527777777777800;
	
	// https://en.wikipedia.org/wiki/Walking
	// Average walking speed is 5.32kph, which converts to 1.4777777777777800 mps
	private final double MAX_WALK_SPEED = 1.4777777777777800;
	
	// https://www.iamlivingit.com/running/average-human-running-speed
	// Average running speed is 13.62kph, which converts to 
	private final double MAX_RUN_SPEED = 3.7833333333333300;
	
	private final double weight = 0.0;
	
	public double getGravity(double seconds) {
		return GRAVITY * seconds;
	}
	public double addGravity(double velocity, double seconds) {
		double newVelocity = velocity + getGravity(seconds);
		return newVelocity > TERMINAL_VELOCITY ? TERMINAL_VELOCITY : newVelocity;
	}
;
	
	
	
	
	public static double metersToPixels(double meters) {
		//character is 1.7m / 30px tall, therefore 1 pixel = (1.7 / 30) = 0.05666666666666666666666666666667 meters 
		return meters * (1.7 / 30);
	}
	public static double pixelsToMeters(double pixels) {
		//character is 30px / 1.7m tall, therefore 1 meter = (30 / 1.7) = 17.647058823529411764705882352941 pixels 
		return pixels * (30 / 1.7);
	}
}
