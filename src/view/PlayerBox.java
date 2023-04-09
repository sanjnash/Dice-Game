package view;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import controller.PlayerBoxController;
import model.interfaces.GameEngine;
import model.interfaces.Player;


public class PlayerBox extends JPanel{

	
	private static final long serialVersionUID = 1L;
	// Adding Player list in DefaultListModel
	private DefaultListModel<String> base;
	
	//Adds Players as a list 
	private JList<String> playerList;


	
	public PlayerBox() {
		this.setMinimumSize(new Dimension(150,0));
		base = new DefaultListModel<>();
		playerList = new JList<>(base);
		playerList.setVisibleRowCount(5);
		playerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		playerList.setFont(new Font(null, Font.ROMAN_BASELINE, 20));
		playerList.requestFocus();
		this.setFocusable(false);
		this.add(playerList, JSplitPane.TOP);
		base.addElement("House");
		playerList.setSelectedIndex(0);
	}

	public void addListeners(MainFrame mainFrame, GameEngine gameEngine) {
		PlayerBoxController listener = new PlayerBoxController(mainFrame, gameEngine);
		playerList.addListSelectionListener(listener);
		playerList.addKeyListener(listener);
	}

	public void selectPlayer(GameEngine gameEngine) {
		base.removeAllElements();
		addPlayer(gameEngine);
		setSelectedPlayer(0);

	}
	
	public boolean playerIsSelected(int count) {
		return playerList.getSelectedIndex() != count
				&& playerList.getSelectedIndex() != -1;
	}
	
	public void setSelectedPlayer(int index) {
		playerList.setSelectedIndex(index);
	}

	// adds the player in the List
	public void addPlayer(GameEngine gameEngine) {
		for (Player player : gameEngine.getAllPlayers()) {
			String details =  player.getPlayerId() 
					+ " - " + player.getPlayerName();
			base.addElement(details);		
		}
		base.addElement("House");

	}
	
	// Returns false if the player is not spinned, (If the results is not printed the player will not be spinned)
	public boolean Playespun(GameEngine gameEngine) {
		for (Player search : gameEngine.getAllPlayers()) {
			if (search.getResult() != null) {
				return true;
				
			}
		}
		return false;
	}
	
	//	Checks the player that is selected
	public int getSelectedIndex() {
		return playerList.getSelectedIndex();
	}
	

	}
