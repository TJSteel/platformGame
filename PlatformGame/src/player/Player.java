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
	private double positionY = 76;
	private Sprite sprite = new Sprite("adventurerSheet", Constants.SPRITE_SIZE_X, Constants.SPRITE_SIZE_Y);
	
	private Animation idle = new Animation(new BufferedImage[] {
			sprite.getSprite(8, 9),
			sprite.getSprite(9, 9),
			sprite.getSprite(0, 10),
			sprite.getSprite(1, 10)
			}, 175);
	private Animation crouch = new Animation(new BufferedImage[] {
			sprite.getSprite(5, 6),
			sprite.getSprite(6, 6),
			sprite.getSprite(7, 6),
			sprite.getSprite(8, 6)
			}, 175);
	private Animation walk = new Animation(new BufferedImage[] {
			sprite.getSprite(7, 18),
			sprite.getSprite(8, 18),
			sprite.getSprite(9, 18),
			sprite.getSprite(0, 19),
			sprite.getSprite(1, 19),
			sprite.getSprite(2, 19)
			}, 100);
	
	private Animation currentAnimation = idle;
	private Direction direction = Direction.RIGHT;
	
	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	public BufferedImage getSprite() {
		BufferedImage img = currentAnimation.getSprite();
		if (this.direction == Direction.LEFT) img = Sprite.flipImage(img);
		return img;
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
				direction = Direction.LEFT;
				if (currentAnimation != walk) {
					currentAnimation = walk;
					currentAnimation.reset();
				}
			} else {
				speedX += Constants.SPEED_INCREMENT;
				direction = Direction.RIGHT;
				if (currentAnimation != walk) {
					currentAnimation = walk;
					currentAnimation.reset();
				}
			}
			if (speedX > Constants.MAX_WALK_SPEED) speedX = Constants.MAX_WALK_SPEED;
			if (speedX < -Constants.MAX_WALK_SPEED) speedX = -Constants.MAX_WALK_SPEED;
		} else {
			if (speedX > 0) {
				if (speedX <= Constants.SPEED_INCREMENT){
					speedX = 0;
					currentAnimation = idle;
				} else {
					speedX -= Constants.SPEED_INCREMENT;
				}
			} else if (speedX < 0) {
				if (speedX >= -Constants.SPEED_INCREMENT) {
					speedX = 0;
					currentAnimation = idle;
				} else {
					speedX += Constants.SPEED_INCREMENT;
				}
			}
		}
	}
	public int getX() { return (int)positionX; }
	public int getY() { return (int)positionY; }
}
