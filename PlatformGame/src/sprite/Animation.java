package sprite;

import java.awt.image.BufferedImage;

public class Animation {
	private BufferedImage[] images;
	private int frameChangeSpeed;
	private int currentFrame = 0;
	private int currentSprite = 0;
	
	public Animation(BufferedImage[] images, int frameChangeSpeed) {
		this.images = images;
		this.frameChangeSpeed = frameChangeSpeed;
	}
	
	public BufferedImage getSprite() {
		return images[currentSprite];
	}
	
	public void updateFrame() {
		if (images.length == 1) return;
		currentFrame ++;
		if (currentFrame >= frameChangeSpeed) {
			currentFrame = 0;
			currentSprite++;
			if (currentSprite >= images.length) currentSprite = 0;
		}
	}
	
	public void reset() {
		currentFrame = 0;
		currentSprite = 0;
	}
}
