package player;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.Sprite;

public class Player {
	private short health = 100;
	private short lives = 3;
	private Point speed = new Point(0,0);
	private Point position = new Point(0,0);
	private Sprite sprite = new Sprite("PlayerSprite");
	
	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	public BufferedImage getSprite() {
		return this.sprite.getSprite();
	}
}