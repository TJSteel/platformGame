package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import player.Player;
import settings.Constants;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	public static Player player = new Player();
	
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
      	g2d.drawImage(player.getSprite(), player.getX(), player.getY(), Constants.SPRITE_SIZE_X, Constants.SPRITE_SIZE_Y, null);
        g2d.setColor(Color.BLACK);
    }
    
    public void run() {
        while (true) {
        	player.update();
        	repaint();
        	try {
				Thread.sleep(Constants.GAME_TICK_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
