package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import player.Player;
import settings.Constants;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	private static Player player = new Player();
	private static final int SPRITE_COUNT = 12;
	
	
	public Game() {
		this.setPreferredSize(new Dimension(Constants.SCREEN_RESOLUTION_X, Constants.SCREEN_RESOLUTION_Y));
	}

	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Testing", 10, 10);

      	g2d.drawImage(player.getSprite(), 100, 100, Constants.TILE_SIZE * SPRITE_COUNT, Constants.TILE_SIZE, null);

        
    }
    
    public void run() {
        while (true) {
        	System.out.println("running");
        	repaint();
        	break;
        }
    }
}
