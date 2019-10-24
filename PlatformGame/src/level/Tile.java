package level;

public enum Tile {
	BLANK('0', 5, 0, "Blank", false),
	FLOOR_LEFT('1', 15, 7, "Floor Left", true),
	FLOOR_CENTER('2', 16, 7, "Floor Center", true),
	FLOOR_RIGHT('3', 17, 7, "Floor Right", true),
	GRASS('4', 16, 6, "Grass", false),
	MUD('5', 11, 6, "Mud", true),
	MUD_WALL_BOTTOM_LEFT('6', 15, 9, "Mud Wall Bottom Left", true),
	MUD_WALL_BOTTOM_RIGHT('7', 17, 9, "Mud Wall Bottom Right", true),
	WALL_LEFT('8', 9, 6, "Mud Wall Left", true),
	WALL_RIGHT('9', 13, 6, "Mud Wall Right", true),
	PLATFORM_LEFT_GRASS('A', 14, 2, "Platform Left Grass", true),
	PLATFORM_CENTER_GRASS('B', 15, 2, "Platform Center Grass", true),
	PLATFORM_RIGHT_GRASS('C', 16, 2, "Platform Right Grass", true),
	;
	
	private char id;
	private int x, y;
	private String name;
	private boolean collidable;
	
	private Tile(char id, int x, int y, String name, boolean collidable) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.name = name;
		this.collidable = collidable;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	public boolean isCollidable() {
		return collidable;
	}
	
	public static Tile getById(char id) {
		for (Tile t : values()) {
			if (t.id == id) {
				return t;
			}
		}
		return Tile.BLANK;
	}

}
