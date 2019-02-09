package level;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import settings.Constants;
import sprite.Sprite;

public class Level {
	private Sprite sprite = new Sprite("tilesetSheet", Constants.TILE_SIZE, Constants.TILE_SIZE);
	private int levelNumber;
	private Tile[][] tiles;
	
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
		BufferedImage imgTile;
		switch (tile) {
		case FLOOR_CENTER:
			imgTile = sprite.getSprite(16, 7);
			break;
		default:
			imgTile = sprite.getSprite(5, 0);
		}
		return imgTile;
		
	}
	
	private void loadLevel() {
		Tile[][] tiles = new Tile[Constants.GAME_RESOLUTION_X / Constants.TILE_SIZE][Constants.GAME_RESOLUTION_Y / Constants.TILE_SIZE];
	    for (int row = 0; row<tiles.length; row++) {
		    for (int column = 0; column<tiles[row].length; column++) {
			    tiles[row][column] = Tile.BLANK;
		    }
	    }
		
		tiles[0][7] = Tile.FLOOR_CENTER;
		tiles[1][7] = Tile.FLOOR_CENTER;
		tiles[2][7] = Tile.FLOOR_CENTER;
		tiles[3][7] = Tile.FLOOR_CENTER;
		tiles[4][7] = Tile.FLOOR_CENTER;
		tiles[5][7] = Tile.FLOOR_CENTER;
		tiles[6][7] = Tile.FLOOR_CENTER;
		tiles[7][7] = Tile.FLOOR_CENTER;
		tiles[8][7] = Tile.FLOOR_CENTER;
		tiles[9][7] = Tile.FLOOR_CENTER;
		tiles[10][7] = Tile.FLOOR_CENTER;
		tiles[11][7] = Tile.FLOOR_CENTER;
		tiles[12][7] = Tile.FLOOR_CENTER;
		tiles[13][7] = Tile.FLOOR_CENTER;
		tiles[14][7] = Tile.FLOOR_CENTER;

		this.tiles = tiles;
	}
}
