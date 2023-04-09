package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallBackGui implements GameEngineCallback {
	
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());
	private MainFrame mainFrame;
	
	public GameEngineCallBackGui(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void playerDieUpdate(Player player, Die die, GameEngine gameEngine) {
		SwingUtilities.invokeLater(() -> {
		String toPrint = player.getPlayerName() + " die " + die.getNumber() + " Rolled to " + die.toString() ;//add
		
		// final results logged at Level.FINE
		logger.log(Level.FINE, toPrint);
		});
	}

	@Override
	public void houseDieUpdate(Die die, GameEngine gameEngine) {
		SwingUtilities.invokeLater(() -> {
		String toPrint = "House "+ "die " + die.getNumber() + " Rolled to " + die.toString() ;
			
			// final results logged at Level.FINE
			logger.log(Level.FINE, toPrint);
		
		});
	}

	@Override
	public void playerResult(Player player, DicePair result, GameEngine gameEngine) {
		SwingUtilities.invokeLater(() -> {
		String toPrint =  player.getPlayerName() + ", *RESULT*: " + result.toString() ;
		
		// final results logged at Level.FINE
		logger.log(Level.FINE, toPrint);
		});
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		SwingUtilities.invokeLater(() -> {
		String toPrint = "House: *RESULT* " + result.toString();
		
		
		logger.log(Level.INFO, toPrint);
		});
		
	}

}
