package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;




public class SummaryPanel extends JSplitPane {

	GameEngine engine = new GameEngineImpl();
	private static final long serialVersionUID = 1L;
	
	//Text Area for printing Player Details
	private JTextArea gameDetails;
	private JLabel label;
	//Printing Details on Summary Panel
	public SummaryPanel() {
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setMinimumSize(new Dimension(200,40));

		gameDetails = new JTextArea();
		gameDetails.setEditable(false);
		gameDetails.setFocusable(false);
		gameDetails.setFont(new Font(null, Font.BOLD, 14));
		
		label = new JLabel("Results");
		this.setFocusable(false);
		this.setBackground(Color.cyan);
		this.add(label, JSplitPane.TOP );
		this.add(new JScrollPane(gameDetails), JSplitPane.BOTTOM);
		
}
	
	//Printing Method for PLayer Details
	public void print(String enterText) {
		String [] playerDetails = {
				enterText + "\n" 
			};
		printing(playerDetails);
	}
	
	//Printing Pattern
	private void printing(String[] space) {
		for (String spaces : space) {
			gameDetails.append(spaces + "\n");
		}
	}
	
	//Checker for ApplyWinLoss
	public void checker(GameEngine gameEngine, Player player) {
		gameEngine.applyWinLoss(player, player.getResult());
	}
	
	//Getting Player Id
	public String getPlayerinfo(Player player) {
		
		String s = "ID: " + player.getPlayerId() + "\n" + "Name: "+ player.getPlayerName() +"\n" +
		"Bet: " +	player.getBet()	+ "\nPoints: "+ player.getPoints() +"\nResult...\nDice 1: "
			+	player.getResult().getDie1() + "\nDice 2: " + player.getResult().getDie2();
		return s;
		
	}
	


	}
