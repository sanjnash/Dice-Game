package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.interfaces.GameEngine;

public class StatusBar extends JPanel {

	private JLabel gameState;
	private final String defaultLabel = " Please Add a Player";

	public StatusBar(){
		gameState = new JLabel(defaultLabel, JLabel.CENTER);
		gameState.setFont(new Font(null, Font.BOLD , 14));
		this.add(gameState);
		this.setBackground( new Color(200,200,255) );
		setLayout(new GridLayout(1, 1));
		
		this.setFocusable(false);
			}
	
	public void addlabels(MainFrame mainFrame, GameEngine gameEngine) {
		int i = gameEngine.getAllPlayers().size();
		if (gameEngine.getAllPlayers().size() == 1) {
			setLabel("Player is added");
			}
		else if(gameEngine.getAllPlayers().size() > 1) {
			setLabel(i + "number of Players Added");
		}

	}
	
	// Clears Label
	public void clearText() {
		gameState.setText("");
	}
	
	// setLabel as SomethingElse
	public void setLabel(String comment) {
		gameState.setText(comment);
	}

}
