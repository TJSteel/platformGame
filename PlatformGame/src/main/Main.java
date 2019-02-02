package main;

import game.Game;
import ui.UI;

public class Main {

	public static UI ui;
	public static Game game = new Game();
	
	public static void main(String[] args) {
        ui = new UI();
        ui.setVisible(true);
        game.run();
	}

}
