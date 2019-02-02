package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sprite {
	private BufferedImage spriteSheet = null;
	
	public Sprite(String spriteName) {
		loadSprite(spriteName);
	}
	
	public BufferedImage getSprite() {
		return this.spriteSheet;
	}
	
	private void loadSprite(String spriteName) {
		try {
			System.out.println("loading sprite");
			this.spriteSheet = ImageIO.read(getClass().getResource("/images/" + spriteName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (this.spriteSheet == null) {
			loadBlankSprite();
		}
	}
	
	private void loadBlankSprite() {
		
	}
	
	
}
