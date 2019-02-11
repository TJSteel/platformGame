package level;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import settings.Constants;
import sprite.Sprite;

public class Level {
	private Sprite sprite = new Sprite("tilesetSheet", Constants.TILE_SIZE, Constants.TILE_SIZE);
	private int levelNumber;
	private Tile[][] tiles;
	private Background[] background;
	
	
	public Level(int levelNumber) {
		this.levelNumber = levelNumber;
		loadLevel();
	}
	public BufferedImage drawLevel() {
		BufferedImage bimage = new BufferedImage(Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y, BufferedImage.TYPE_INT_ARGB); 
		int tileSize = Constants.TILE_SIZE;
		
	    Graphics2D g2d = bimage.createGraphics();
	    for (int row = 0; row<this.tiles.length; row++) {
		    for (int column = 0; column<this.tiles[row].length; column++) {
			    g2d.drawImage(getTile(this.tiles[row][column]), row*tileSize, column*tileSize, tileSize, tileSize, null);
		    }
	    }
	    g2d.dispose();
		return bimage;
	}
	
	private BufferedImage getTile(Tile tile) {
		return sprite.getSprite(tile.getX(), tile.getY());
	}
	
	private void loadLevel() {
		if (levelNumber == 1) {
			Background[] bg = {
					new Background("sky", 0, 0, 1, 0.1),
					new Background("clouds", 0, 0.4, 0.3, 0.5),
					new Background("sea", 0, 0.7, 0.3, .8)
			};
			this.background = bg;
		}
		Tile[][] tiles = new Tile[40][10];
	    for (int row = 0; row<tiles.length; row++) {
		    for (int column = 0; column<tiles[row].length; column++) {
			    tiles[row][column] = Tile.BLANK;
		    }
	    }
		
	    int c = 0;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.GRASS;
		tiles[c][8] = Tile.FLOOR_LEFT;
		tiles[c][9] = Tile.MUD_WALL_BOTTOM_LEFT;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.GRASS;
		tiles[c][7] = Tile.FLOOR_LEFT;
		tiles[c][8] = Tile.MUD_WALL_BOTTOM_LEFT;
		tiles[c][9] = Tile.MUD;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.GRASS;
		tiles[c][7] = Tile.FLOOR_RIGHT;
		tiles[c][8] = Tile.WALL_RIGHT;
		tiles[c][9] = Tile.MUD_WALL_BOTTOM_RIGHT;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;
		tiles[c][0] = Tile.BLANK;
		tiles[c][1] = Tile.BLANK;
		tiles[c][2] = Tile.BLANK;
		tiles[c][3] = Tile.BLANK;
		tiles[c][4] = Tile.BLANK;
		tiles[c][5] = Tile.BLANK;
		tiles[c][6] = Tile.BLANK;
		tiles[c][7] = Tile.BLANK;
		tiles[c][8] = Tile.GRASS;
		tiles[c][9] = Tile.FLOOR_CENTER;
		c++;

		this.tiles = tiles;
	}
	
	public boolean isColliding(Rectangle2D.Double rectangle) {
		int tileSize = Constants.TILE_SIZE;
		//create a loop which will only check squares on the map the rectangle is near
		int rowFrom = (int) Math.floor(rectangle.x / tileSize);
		int rowTo = (int) Math.floor((rectangle.x + rectangle.width) / tileSize) + 1;
		int columnFrom = (int) Math.floor(rectangle.y / tileSize);
		int columnTo = (int) Math.floor((rectangle.y + rectangle.height) / tileSize) + 1;
		
		for (int row = rowFrom; row <= rowTo; row++) {
			for (int column = columnFrom; column <= columnTo; column++) {
				//don't check tiles that are off the map
				if (row >= tiles.length || row < 0 || column >= tiles[0].length || column < 0) continue;
				if (this.tiles[row][column].isCollidable()) {
					Rectangle2D.Double tile = new Rectangle2D.Double(row * tileSize, column * tileSize, tileSize, tileSize);
					if (rectangle.intersects(tile)) return true;
				}
			}
		}

		
		//inside the loop, check for tile type and only check collision if tile is solid
		
		return false;

	}

	public void update() {
		
	}
	
	public BufferedImage drawBackground() {
		BufferedImage bimage = new BufferedImage(Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y, BufferedImage.TYPE_INT_ARGB); 
		
	    Graphics2D g2d = bimage.createGraphics();
	    for (Background background: this.background) {
	    	g2d.drawImage(background.getBackground(), 0, 0, Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y, null);
	    }
	    g2d.dispose();

	    return bimage;
	}
}
