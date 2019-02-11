package sprite;

import java.awt.image.BufferedImage;

import game.Game;

public class Animation {
	private BufferedImage[] images;
	private long frameChangeSpeed;
	private int currentSprite = 0;
	private long startTime;
	private String name;
	
	public Animation(String name, BufferedImage[] images, int frameChangeSpeed) {
		this.name = name;
		this.images = images;
		this.frameChangeSpeed = frameChangeSpeed * 1000000; //enter milliseconds and convert to nanoseconds
		this.startTime = System.nanoTime();
	}
	
	public BufferedImage getSprite() {
		return images[currentSprite];
	}
	
	public void updateFrame() {
		//if only 1 image present, no need to updateFrame as there is no animation
		if (images.length == 1) return;

		while ((System.nanoTime() - startTime) > frameChangeSpeed) {
			startTime += frameChangeSpeed;
			currentSprite++;
			if (currentSprite >= images.length) {
				currentSprite = 0;
				Game.player.finishedAnimation();
			}
		}
	}
	
	public void reset() {
		currentSprite = 0;
		startTime = System.nanoTime();
	}
	
	public String getName() {
		return this.name;
	}
}
