package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;



public class ToolBarController extends KeyAdapter implements ActionListener {
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	
	//	Delay Increments
	private final int initialDelay1 = 100;
	private final int finalDelay1 = 1000;
	private final int delayIncrement1 = 100;
	private final int initialDelay2 = 50;
	private final int finalDelay2 = 500;
	private final int delayIncrement = 50;

	//	House Player
	Player player1 = new SimplePlayer("1","House",1000);

	
	//	ToolBar Constructor
	public ToolBarController(MainFrame mainFrame, GameEngine gameEngine) {
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;

	}

	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "placeBet":
			placeBet();
			break;
		case "Roll":
			Roll();
			break;
		case "cancelBet":
			cancelBet();
			break;
		}
	}

	// CancelBet method
	private void cancelBet() {
		mainFrame.getToolbar().clearBetText();
		mainFrame.getToolbar().setbet("100");
		mainFrame.getStatusBar().setLabel("Bet Cancelled");
		mainFrame.getToolbar().setRollButton(false);
		mainFrame.getToolbar().setBetInputEnabled(true);
		int i = mainFrame.getPlayerBox().getSelectedIndex();
		List<Player> list = new ArrayList<>(gameEngine.getAllPlayers());
		Player player = list.get(i);
		player.resetBet();
		
	}

	// Dice Roll Method
	private void Roll() {
			int i = mainFrame.getPlayerBox().getSelectedIndex();
			
			List<Player> list = new ArrayList<>(gameEngine.getAllPlayers());
			list.add(player1);
			Player player = list.get(i);
			
			if (player.getBet() != 0 ) {
				gameEngine.rollPlayer(player, initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2,
						delayIncrement);
//				gameEngine.rollPlayer(player1, initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2,
//						delayIncrement);
				}

			 for(Player plyaer: gameEngine.getAllPlayers()) {
				mainFrame.getsummaryPanel().print("Player Rolled!\n");
				mainFrame.getDiePanel().roll(plyaer.getResult().getDie1().getValue(), plyaer.getResult().getDie2().getValue());
				gameEngine.applyWinLoss(plyaer, plyaer.getResult());
				String info = mainFrame.getsummaryPanel().getPlayerinfo(player);
				mainFrame.getsummaryPanel().print(info);
			
			   }
			
			if (mainFrame.getPlayerBox().Playespun(gameEngine)) {
				mainFrame.getStatusBar().setLabel("All Dices Rolled!");
				gameEngine.rollHouse(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2,delayIncrement);
				String info = mainFrame.getsummaryPanel().getPlayerinfo(player1);
				mainFrame.getsummaryPanel().print(info);
			}
			
			mainFrame.getToolbar().setRollButton(false);
			mainFrame.getToolbar().setCancelButton(false);
			mainFrame.getToolbar().setbet("0");
	}
	
	// Place Bet Method
	private void placeBet() {
		mainFrame.getStatusBar().addlabels(mainFrame, gameEngine);
		int i = mainFrame.getPlayerBox().getSelectedIndex();
		List<Player> list = new ArrayList<>(gameEngine.getAllPlayers());
		list.add(player1);
		Player player = list.get(i);
		int bet = Integer.parseInt(mainFrame.getToolbar().getBetText());
		
	try {
			if ( "0".equals(mainFrame.getToolbar().getBetText()) || "".equals(mainFrame.getToolbar().getBetText()))
				throw new IllegalArgumentException("Amount of Bet not Valid");
		
		if(bet > player.getPoints())
			throw new IllegalArgumentException("Amount of Bet not Valid");
		
		if (!gameEngine.placeBet(player, bet))
				throw new IllegalArgumentException("Amount of Bet not Valid");

		mainFrame.getToolbar().setBetInputEnabled(false);
		mainFrame.getToolbar().setRollButton(true);
		mainFrame.getToolbar().setCancelButton(true);
		mainFrame.getStatusBar().setLabel("Bet Placed");
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
		}
} 

}



