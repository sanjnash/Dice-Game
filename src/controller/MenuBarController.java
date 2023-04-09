package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class MenuBarController implements ActionListener {
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	public MenuBarController(MainFrame mainFrame, GameEngine gameEngine) {
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "addPlayer":
			addPlayer();
			break;
		case "removePlayer":
			removePlayer();
			break;	
		}
	}

	private void addPlayer() {
		mainFrame.getAddPlayer().centerDialogToMainWindow(mainFrame);
		mainFrame.getAddPlayer().setVisible(true);
	}

	private void removePlayer() {
		int i = mainFrame.getPlayerBox().getSelectedIndex();
		List<Player> list = new ArrayList<>(gameEngine.getAllPlayers());
		Player player = list.get(i);
	
		if (list.size() > 0
				&& gameEngine.getAllPlayers().size() !=  i) {
					gameEngine.removePlayer(player);
					mainFrame.getPlayerBox().selectPlayer(gameEngine);
		
		}
	}


	

}
