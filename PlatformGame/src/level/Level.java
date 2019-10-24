package level;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Game;
import settings.Constants;
import sprite.Sprite;
import tools.CustomFileReader;

public class Level {
	private Sprite sprite = new Sprite("tilesetSheet", Constants.TILE_SIZE, Constants.TILE_SIZE);
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private int levelNumber;
	private Tile[][] tiles;
	private Background[] background;
	private double offsetX = 0;
	private double scrollMarkerXHigh = Constants.GAME_RESOLUTION_X * 0.4;
	private double scrollMarkerXLow = Constants.GAME_RESOLUTION_X * 0.1;
	private double scrollMarkerXMin = 0;
	private double scrollMarkerXMax = 0;

	
	
	public int getOffsetX() {
		return (int)offsetX;
	}

	private void setOffsetX(double offsetX) {
		this.offsetX = offsetX;
		if (this.offsetX > this.scrollMarkerXMax) this.offsetX = this.scrollMarkerXMax;
		if (this.offsetX < this.scrollMarkerXMin) this.offsetX = this.scrollMarkerXMin;
	}

	public Level(int levelNumber) {
		loadLevel(levelNumber);
	}
	
	public BufferedImage drawLevel() {
		BufferedImage bimage = new BufferedImage(Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y, BufferedImage.TYPE_INT_ARGB); 
		int tileSize = Constants.TILE_SIZE;
		
	    Graphics2D g2d = bimage.createGraphics();
	    for (int row = 0; row<this.tiles.length; row++) {
		    for (int column = 0; column<this.tiles[row].length; column++) {
		    	int tileX = row*tileSize-this.getOffsetX();
		    	int tileY = column*tileSize;
		    	//only draw if the tile fits the screen
		    	if (tileX+tileSize > 0 && tileX < Constants.GAME_RESOLUTION_X &&
		    			tileY+tileSize > 0 && tileY < Constants.GAME_RESOLUTION_Y) {
				    g2d.drawImage(getTile(this.tiles[row][column]), tileX, tileY, tileSize, tileSize, null);
		    	}
		    }
	    }
	    g2d.dispose();
		return bimage;
	}
	
	private BufferedImage getTile(Tile tile) {
		return sprite.getSprite(tile.getX(), tile.getY());
	}
	
	private void loadLevel(int levelNumber) {
		String[] inputFile = CustomFileReader.readTextFile("src/level/level" + levelNumber + ".txt");
		ArrayList<String> tileStrings = new ArrayList<String>();
		// get settings of the level from the top of the file
		
		for (String s : inputFile) {
			if (s.contains("levelNumber: ")) {
				this.levelNumber = Integer.parseInt(s.substring(12).trim());
			} else if (s.contains("name: ")) {
				this.name = s.substring(5).trim();
			} else if (s.contains("playerX: ")) {
				Game.player.setX(Integer.parseInt(s.substring(8).trim()));
			} else if (s.contains("playerY: ")) {
				Game.player.setY(Integer.parseInt(s.substring(8).trim()));
			} else if (s.contains("tiles:")) {
				tileStrings.add(s.substring(6).trim());
			}
		}
		
		// get tiles from the remainder of the file
		int columnCount = tileStrings.get(0).length(); 
		int rowCount = tileStrings.size();

		Tile[][] tiles = new Tile[columnCount][rowCount];
	    
		for (int row = 0; row < rowCount; row++) {
		    for (int column = 0; column < columnCount; column++) {
			    tiles[column][row] = Tile.getById(tileStrings.get(row).charAt(column));
		    }
	    }
		

		// not sure how to process this yet, possibly via the level file too
		Background[] bg = {
				new Background("sky", 0, 0, 1, 0.1),
				new Background("clouds", 0, 0.4, 0.3, 0.3),
				new Background("sea", 0, 0.7, 0.3, .5)
		};
		this.background = bg;
		

		
	    this.scrollMarkerXMax = ((tiles.length)*Constants.TILE_SIZE) - Constants.GAME_RESOLUTION_X;

		this.tiles = tiles;
	}
	
	public boolean isColliding(Rectangle2D.Double rectangle) {
		int tileSize = Constants.TILE_SIZE;
		// start by checking out of bounds
		if (rectangle.x < 0 || rectangle.x > tiles.length * tileSize) return true;
		
		//create a loop which will only check squares on the map the rectangle is near
		int columnFrom = (int) Math.floor(rectangle.x / tileSize);
		int columnTo = (int) Math.floor((rectangle.x + rectangle.width) / tileSize) + 1;
		int rowFrom = (int) Math.floor(rectangle.y / tileSize);
		int rowTo = (int) Math.floor((rectangle.y + rectangle.height) / tileSize) + 1;
		
		for (int column = columnFrom; column <= columnTo; column++) {
			for (int row = rowFrom; row <= rowTo; row++) {
				//don't check tiles that are off the map
				if (column >= tiles.length || column < 0 || row >= tiles[0].length || row < 0) continue;
				if (this.tiles[column][row].isCollidable()) {
					Rectangle2D.Double tile = new Rectangle2D.Double(column * tileSize, row * tileSize, tileSize, tileSize);
					if (rectangle.intersects(tile)) return true;
				}
			}
		}
		
		//inside the loop, check for tile type and only check collision if tile is solid
		
		return false;

	}

	public void update() {
		updateOffset();
	}
	
	private void updateOffset() {
		double playerX = Game.player.getX();
		double playerOffsetX = playerX -= this.getOffsetX();
		if (Constants.DEBUG_MODE)System.out.println(playerOffsetX + ", " + scrollMarkerXLow);
		
		// convert playerX to actual screen position rather than global position
		if (playerOffsetX > scrollMarkerXHigh) {
			this.setOffsetX(this.getOffsetX() + (playerOffsetX-scrollMarkerXHigh));
		} else if (playerOffsetX < scrollMarkerXLow) {
			this.setOffsetX(this.getOffsetX() - (scrollMarkerXLow-playerOffsetX));
		} 
	}
	
	public BufferedImage drawBackground() {
		BufferedImage bimage = new BufferedImage(Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y, BufferedImage.TYPE_INT_ARGB); 
		
	    Graphics2D g2d = bimage.createGraphics();
	    for (Background background: this.background) {
	    	g2d.drawImage(background.getBackground(this.getOffsetX()), 0, 0, Constants.GAME_RESOLUTION_X, Constants.GAME_RESOLUTION_Y, null);
	    }
	    g2d.dispose();

	    return bimage;
	}
}
