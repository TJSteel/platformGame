package sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import settings.Constants;


public class Sprite {
	private BufferedImage spriteSheet = null;
	
	public Sprite(String spriteName) {
		loadSprite(spriteName);
	}
	
	public BufferedImage getSprite(int x, int y) {
		int size = Constants.TILE_SIZE;
		x *= size;
		y *= size;
		if (x > (spriteSheet.getWidth() - size)) x = 0;
		if (y > (spriteSheet.getHeight() - size)) y = 0;
		
		return spriteSheet.getSubimage(x, y, size, size);
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
	public static final BufferedImage flipImage(BufferedImage img)
	{
		int size = Constants.TILE_SIZE;
	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D g2d = bimage.createGraphics();
	    g2d.drawImage(img, size, 0, -size, size, null);
	    g2d.dispose();

	    // Return the buffered image
	    return bimage;
	}
}
