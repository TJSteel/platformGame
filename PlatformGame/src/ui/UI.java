package ui;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import main.Main;
import settings.Constants;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public UI() {
		addKeyListener(new AL());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Constants.SCREEN_RESOLUTION_X, Constants.SCREEN_RESOLUTION_Y);
		setContentPane(Main.game);
		setVisible(true);
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode){
			case KeyEvent.VK_LEFT:
				Game.player.keyLeft = true;
				break;
			case KeyEvent.VK_RIGHT:
				Game.player.keyRight = true;
				break;
			case KeyEvent.VK_UP:
				Game.player.keyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				Game.player.keyDown = true;
				break;
			case KeyEvent.VK_Z:
				Game.player.keyRun = true;
				break;
			}
		}
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode){
			case KeyEvent.VK_LEFT:
				Game.player.keyLeft = false;
				break;
			case KeyEvent.VK_RIGHT:
				Game.player.keyRight = false;
				break;
			case KeyEvent.VK_UP:
				Game.player.keyUp = false;
				break;
			case KeyEvent.VK_DOWN:
				Game.player.keyDown = false;
				break;
			case KeyEvent.VK_Z:
				Game.player.keyRun = false;
				break;
			}
		}
	}	
	
}
