package controller;

import java.awt.event.KeyAdapter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.interfaces.GameEngine;
import view.MainFrame;

public class PlayerBoxController extends KeyAdapter implements ListSelectionListener {
	
	 GameEngine gameEngine;
	private MainFrame mainFrame;

	public PlayerBoxController(MainFrame mainFrame, GameEngine gameEngine) {
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			mainFrame.getToolbar().setBetInputEnabled(true);
			}
	}
}

