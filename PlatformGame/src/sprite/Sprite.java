package sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private BufferedImage spriteSheet = null;
	private int sizeX;
	private int sizeY;
	
	public Sprite(String spriteName, int sizeX, int sizeY) {
		loadSprite(spriteName);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public BufferedImage getSprite(int x, int y) {
		x *= this.sizeX;
		y *= this.sizeY;
		if (x > (spriteSheet.getWidth() - this.sizeX)) x = 0;
		if (y > (spriteSheet.getHeight() - this.sizeY)) y = 0;
		
		return spriteSheet.getSubimage(x, y, this.sizeX, this.sizeY);
	}
	
	private void loadSprite(String spriteName) {
		try {
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
	public static BufferedImage flipImage(BufferedImage img)
	{
		int width = img.getWidth(null);
		int height = img.getHeight(null);
	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D g2d = bimage.createGraphics();
	    g2d.drawImage(img, width, 0, -width, height, null);
	    g2d.dispose();

	    // Return the buffered image
	    return bimage;
	}
}
