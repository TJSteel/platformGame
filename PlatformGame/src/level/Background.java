package level;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import settings.Constants;

public class Background {
	public BufferedImage img;
	public double x;
	public double y;
	public double height;
	public double speed;
	public String imageName;
	public Background(String img, double x, double y, double height, double speed) {
		this.imageName = img;
		try {
			this.img = ImageIO.read(getClass().getResource("/images/" + img + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x*Constants.GAME_RESOLUTION_X;
		this.y = y*Constants.GAME_RESOLUTION_Y;
		this.height = height*Constants.GAME_RESOLUTION_Y;
		this.speed = speed;
	}
	public BufferedImage getBackground(double offset) {

		double x = this.x;
		x = x - (offset * this.speed);
		double width = this.getWidth();
		
		//find location of first image to draw
		while ((x + width) < 0) {
			x += width;
		}
		
		// Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage((int)(Constants.GAME_RESOLUTION_X), (int)Constants.GAME_RESOLUTION_Y, BufferedImage.TYPE_INT_ARGB);
	    
	    Graphics2D g2d = bimage.createGraphics();
	    while (x <= Constants.GAME_RESOLUTION_X + width + width && width > 0) {
	    	g2d.drawImage(img, (int)x, (int)this.y, (int)width, (int)this.height, null);
	    	x += width;
	    }
	    
	    g2d.dispose();
		return bimage;
	}
	public double getOffsetX(double offset) {
		return this.x - offset * this.speed;
	}
	public int getWidth() {
		double imgRatio = (double)img.getWidth() / img.getHeight();
		return (int)(this.height * imgRatio);
	}
	public int getHeight() {
		return (int) this.height;
	}
}
