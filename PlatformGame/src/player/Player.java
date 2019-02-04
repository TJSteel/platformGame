package player;

import java.awt.image.BufferedImage;

import settings.Constants;
import sprite.Animation;
import sprite.Sprite;

public class Player {
	public boolean keyLeft = false, keyRight = false, keyUp = false, keyDown = false;
	private short health = 100;
	@SuppressWarnings("unused")
	private short lives = 3;
	private double speedX = 0;
	private double speedY = 0;
	private double positionX = 0;
	private double positionY = 0;
	private Sprite sprite = new Sprite("PlayerSprite");
	
	private Animation standRight = new Animation(new BufferedImage[] {
			sprite.getSprite(0, 0)
			}, 0);
	private Animation standLeft = new Animation(new BufferedImage[] {
			Sprite.flipImage(sprite.getSprite(0, 0))
			}, 0);
	private Animation walkRight = new Animation(new BufferedImage[] {
			sprite.getSprite(0, 0),
			sprite.getSprite(1, 0),
			sprite.getSprite(2, 0),
			sprite.getSprite(1, 0),
			sprite.getSprite(0, 0),
			sprite.getSprite(4, 0),
			sprite.getSprite(5, 0),
			sprite.getSprite(4, 0)
			}, 10);
	private Animation walkLeft = new Animation(new BufferedImage[] {
			Sprite.flipImage(sprite.getSprite(0, 0)),
			Sprite.flipImage(sprite.getSprite(1, 0)),
			Sprite.flipImage(sprite.getSprite(2, 0)),
			Sprite.flipImage(sprite.getSprite(1, 0)),
			Sprite.flipImage(sprite.getSprite(0, 0)),
			Sprite.flipImage(sprite.getSprite(4, 0)),
			Sprite.flipImage(sprite.getSprite(5, 0)),
			Sprite.flipImage(sprite.getSprite(4, 0))
			}, 10);
	
	
	
	
	private Animation currentAnimation = standRight;
	
	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	public BufferedImage getSprite() {
		return currentAnimation.getSprite();
	}
	public void update() {
		updatePlayerInputs();

		
		
		currentAnimation.updateFrame();
		positionX += speedX;
		positionY += speedY;
	}
	private void updatePlayerInputs() {
		if (keyLeft == true ^ keyRight == true) {
			if (keyLeft == true) {
				speedX -= Constants.SPEED_INCREMENT;
				if (currentAnimation != walkLeft) {
					currentAnimation = walkLeft;
					currentAnimation.reset();
				}
			} else {
				speedX += Constants.SPEED_INCREMENT;
				if (currentAnimation != walkRight) {
					currentAnimation = walkRight;
					currentAnimation.reset();
				}
			}
			if (speedX > Constants.MAX_WALK_SPEED) speedX = Constants.MAX_WALK_SPEED;
			if (speedX < -Constants.MAX_WALK_SPEED) speedX = -Constants.MAX_WALK_SPEED;
		} else {
			if (speedX > 0) {
				if (speedX <= Constants.SPEED_INCREMENT){
					speedX = 0;
					currentAnimation = standRight;
				} else {
					speedX -= Constants.SPEED_INCREMENT;
				}
			} else if (speedX < 0) {
				if (speedX >= -Constants.SPEED_INCREMENT) {
					speedX = 0;
					currentAnimation = standLeft;
				} else {
					speedX += Constants.SPEED_INCREMENT;
				}
			}
		}
	}
	public int getX() { return (int)positionX; }
	public int getY() { return (int)positionY; }
}
