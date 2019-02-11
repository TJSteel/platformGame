package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import level.Level;
import player.Player;
import settings.Constants;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	public static Player player = new Player();
	public static Level level = new Level(1);
	public static boolean running = true;
	
	public Game() {
		this.setPreferredSize(new Dimension(Constants.SCREEN_RESOLUTION_X, Constants.SCREEN_RESOLUTION_Y));
	}

	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(Constants.SIZE_MULTIPLIER, Constants.SIZE_MULTIPLIER);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y);
      	g2d.drawImage(level.drawBackground(), 0, 0, null);
      	g2d.drawImage(level.drawLevel(), 0, 0, null);
      	g2d.drawImage(player.getSprite(), (int)player.getX(), (int)player.getY(), null);
      	g2d.setColor(Color.RED);
      	if (Constants.DEBUG_MODE) g2d.draw(player.getLegs());
        g2d.setColor(Color.BLACK);
    }
    
    public void run() {
    	long startTime = System.nanoTime();
    	double deltaUPS = 0, deltaFPS = 0;
    	@SuppressWarnings("unused") //only used for debugging
		int frames = 0, ticks = 0;
    	long timer = System.currentTimeMillis();
    	
        while (running) {
        	
        	//get the current time, add the time elapsed to the UPS and FPS variables in fractions of that variable
        	//eventually the variable will be >= 1 and then we will perform the frame update or graphics update
        	long currentTime = System.nanoTime();
        	deltaUPS += (currentTime - startTime) / Constants.GAME_UPS;
        	deltaFPS += (currentTime - startTime) / Constants.GAME_FPS;
        	startTime = currentTime;
        	
        	if (deltaUPS >=1) {
        		player.update();
        		level.update();
        		ticks++;
        		deltaUPS--;
        	}
        	
        	if (deltaFPS >=1) {
        		repaint();
        		frames++;
        		deltaFPS--;
        	}
        	
            if ((System.currentTimeMillis() - timer) > 1000) {
                if (Constants.DEBUG_MODE) System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                frames = 0;
                ticks = 0;
                timer += 1000;
            }        	
        }
    }
}
