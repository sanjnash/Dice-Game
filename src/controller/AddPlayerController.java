package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.MainFrame;

public class AddPlayerController implements ActionListener {
	
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public AddPlayerController(MainFrame mainFrame, GameEngine gameEngine) {
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("addPlayer"))
			addPlayerInGui();
	}

	
	private void addPlayerInGui() {

			String id = mainFrame.getAddPlayer().getidTextText();
			String name = mainFrame.getAddPlayer().getnameTextText();
			int points = Integer.parseInt(mainFrame.getAddPlayer().getPointFieldText());
			gameEngine.addPlayer(new SimplePlayer(id, name, points));
			mainFrame.getAddPlayer().setVisible(false);
			mainFrame.getPlayerBox().selectPlayer(gameEngine);
	}

	
}
