package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, Constants.SCREEN_RESOLUTION_X, Constants.SCREEN_RESOLUTION_Y);
		setContentPane(Main.game);
		setVisible(true);
	}

}
