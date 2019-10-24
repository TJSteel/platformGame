package player;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import game.Game;
import physics.Physics;
import settings.Constants;
import sprite.Animation;
import sprite.Sprite;

public class Player {
	public boolean keyLeft = false, keyRight = false, keyUp = false, keyDown = false, keyRun = false;
	private short health = 100;
	private short lives = 3;
	private double speedX = 0;
	private double speedY = 0;
	private double positionX = 60;
	private double positionY = 0;
	private Sprite sprite = new Sprite("adventurerSheet", Constants.SPRITE_SIZE_X, Constants.SPRITE_SIZE_Y);
	private double lastUpdate = 0;
	// {{ Animations
	private Animation idle = new Animation("idle", new BufferedImage[] {
			sprite.getSprite(8, 9),
			sprite.getSprite(9, 9),
			sprite.getSprite(0, 10),
			sprite.getSprite(1, 10)
			}, 175);
	private Animation crouch = new Animation("crouch", new BufferedImage[] {
			sprite.getSprite(5, 6),
			sprite.getSprite(6, 6),
			sprite.getSprite(7, 6),
			sprite.getSprite(8, 6)
			}, 175);
	private Animation walk = new Animation("walk", new BufferedImage[] {
			sprite.getSprite(7, 18),
			sprite.getSprite(8, 18),
			sprite.getSprite(9, 18),
			sprite.getSprite(0, 19),
			sprite.getSprite(1, 19),
			sprite.getSprite(2, 19)
			}, 100);
	private Animation run = new Animation("run", new BufferedImage[] {
			sprite.getSprite(2, 15),
			sprite.getSprite(3, 15),
			sprite.getSprite(4, 15),
			sprite.getSprite(5, 15),
			sprite.getSprite(6, 15),
			sprite.getSprite(7, 15)
			}, 100);
	private Animation jump = new Animation("jump", new BufferedImage[] {
			sprite.getSprite(9, 10),
			sprite.getSprite(0, 11),
			sprite.getSprite(1, 11),
			sprite.getSprite(2, 11)
			}, 100);
	private Animation fall = new Animation("fall", new BufferedImage[] {
			sprite.getSprite(6, 8),
			sprite.getSprite(7, 8)
			}, 100);
	private Animation slide = new Animation("slide", new BufferedImage[] {
			sprite.getSprite(0, 17),
			sprite.getSprite(1, 17)
			}, 100);
	// }} Animations

	private Animation currentAnimation = idle;
	private Direction direction = Direction.RIGHT;
	
	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	
	public BufferedImage getSprite() {
		BufferedImage img = getCurrentAnimation().getSprite();
		if (this.direction == Direction.LEFT) img = Sprite.flipImage(img);
		return img;
	}
	
	public void update() {
		if (getLastUpdate() == 0) setLastUpdate();
		
		getCurrentAnimation().updateFrame();
		updatePlayerInputs();
		applyEnvironmentalForces();
		
		Rectangle2D.Double legs = getLegs();
		
		if (Game.level.isColliding(new Rectangle2D.Double(legs.getX() + speedX, legs.getY(), legs.getWidth(), legs.getHeight())) == true) {
			stopped();
			speedX = 0;
		} else {
			positionX += speedX;
		}
		// need to get it again in case it changed when moving on the X axis
		legs = getLegs();

		if (Game.level.isColliding(new Rectangle2D.Double(legs.getX(), legs.getY() + speedY, legs.getWidth(), legs.getHeight())) == true) {
			if (speedY > Physics.GRAVITY/Constants.GAME_UPS*2) {
				landed();
			}
			speedY = 0;
		} else {
			positionY += speedY;
		}
		
		setLastUpdate();
	}
	public Rectangle2D.Double getLegs() {
		return new Rectangle2D.Double(this.positionX + 21, this.positionY + 30, 9d, 5d);
	}
	private void updatePlayerInputs() {
		if (keyLeft == true ^ keyRight == true) {
			if (keyLeft == true) {
				this.direction = Direction.LEFT;
			} else {
				this.direction = Direction.RIGHT;
			}
			if (keyRun == true) {
				run();
			} else {
				walk();				
			}
		} 
		
		if (keyUp == true){
			jump();
		}
		
		if (keyDown == true) {
			crouch();
		}

	}
	
	private void walk() {
		speedX = Physics.addWalkSpeed(speedX, getTimeElapsed(), this.direction);
		setCurrentAnimation(walk);
	}

	private void run() {
		speedX = Physics.addRunSpeed(speedX, getTimeElapsed(), this.direction);
		setCurrentAnimation(run);
	}
	
	private void jump() {
		if (speedY == 0) {
			speedY -= Physics.JUMP_ACCELERATION;
			setCurrentAnimation(jump);
			keyUp = false;
		}
	}
	
	private void crouch() {
		setCurrentAnimation(crouch);
	}
	

	private void landed() {
		if (speedY >= Physics.TERMINAL_VELOCITY) {
			setCurrentAnimation(slide);
		} else {
			setCurrentAnimation(idle);
		}
	}
	
	private void stopped() {
		setCurrentAnimation(idle);
		speedX = 0;
	}

	private void falling() {
		setCurrentAnimation(fall);
	}

	private void applyEnvironmentalForces() {
		//slow down character
		if (speedX != 0 && ((keyLeft == false && keyRight == false) || speedX > Physics.MAX_WALK_SPEED || speedX < -Physics.MAX_WALK_SPEED)) {
			speedX = Physics.addFriction(speedX, getTimeElapsed());
			if (speedX == 0) stopped();
		}

		// apply gravity
		speedY = Physics.addGravity(speedY, getTimeElapsed());

		if (speedY > Physics.GRAVITY) falling();
	}
	
	public void finishedAnimation() {
		if (getCurrentAnimation().getName().equals("jump")) {
			setCurrentAnimation(fall);
		} else if (getCurrentAnimation().getName().equals("slide")) {
			setCurrentAnimation(idle);
		}
	}

	private boolean doingAction() {
		if (getCurrentAnimation().getName().equals("jump")) return true;
		if (getCurrentAnimation().getName().equals("fall")) return true;
		return false;
	}
	public double getX() { return positionX; }
	public double getY() { return positionY; }

	/**
	 * @return the currentAnimation
	 */
	private Animation getCurrentAnimation() {
		return currentAnimation;
	}

	/**
	 * @param newAnimation the currentAnimation to set
	 */
	private void setCurrentAnimation(Animation newAnimation) {
		if (!newAnimation.getName().equals(getCurrentAnimation().getName())) {
			
			switch (newAnimation.getName()) {
			case "idle":
				if (speedY < 0) return;
				if (speedX > Physics.FLOOR_FRICTION || speedX < -Physics.FLOOR_FRICTION) newAnimation = walk;
			break;
			case "walk":
			case "run":
				if (doingAction()) return;

				if (speedX > Physics.MAX_WALK_SPEED || speedX < -Physics.MAX_WALK_SPEED) {
					newAnimation = run;
				}
			break;
			case "jump":
				if (doingAction()) return;
			break;
			case "fall":
				if (doingAction()) {
					if (!getCurrentAnimation().getName().equals("jump")) return;
				}
			break;
			}

			if (!newAnimation.getName().equals(getCurrentAnimation().getName())){
				newAnimation.reset();
				this.currentAnimation = newAnimation;
			}
		}
	}

	private double getTimeElapsed() {
		return (System.nanoTime() - this.lastUpdate) / 1000000000;
	}

	private double getLastUpdate() {
		return lastUpdate;
	}

	private void setLastUpdate() {
		this.lastUpdate = System.nanoTime();
	}
	
	public short getLives() {
		return this.lives;
	}
	public double getSpeed() {
		return this.speedX;
	}
	
}
