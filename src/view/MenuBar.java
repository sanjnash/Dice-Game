package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import controller.MenuBarController;
import model.interfaces.GameEngine;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private JMenu menuBar;
	private JMenuItem addPlayer , removePlayer ;

	MenuBar() {
		menuBar = new JMenu("Menu");
		
		addPlayer = new JMenuItem("Add Player");
		addPlayer.setActionCommand("addPlayer");
		removePlayer = new JMenuItem("Remove Player");
		removePlayer.setActionCommand("removePlayer");	
	
		menuBar.add(addPlayer);
		menuBar.add(removePlayer);
		this.add(menuBar);

		this.setFocusable(false);
	}
	
	public void addListeners(MainFrame mainFrame, GameEngine gameEngine) {
		MenuBarController listener = new MenuBarController(mainFrame, gameEngine);
		addPlayer.addActionListener(listener);
		removePlayer.addActionListener(listener);
	
	
	}

}
