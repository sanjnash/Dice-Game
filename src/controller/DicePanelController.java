package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javax.swing.Timer;


import model.interfaces.GameEngine;
import view.DiePanel;
import view.MainFrame;

public class DicePanelController extends ComponentAdapter  implements ActionListener  {


	 GameEngine gameEngine;
	private Timer timer;
	DiePanel d = new DiePanel();
	private final int delay = 125;

	public DicePanelController(MainFrame mainFrame, GameEngine gameEngine) {
	this.timer = new Timer(delay, this);
	this.gameEngine = gameEngine;
	
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		
		if (timer.isRunning())
			timer.restart();
		else
			timer.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.stop();
	}
	
	
}
