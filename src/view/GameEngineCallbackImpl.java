package view;

import java.util.logging.Level;
import java.util.logging.Logger;


import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // FINE shows rolling output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void playerDieUpdate(Player player, Die die, GameEngine gameEngine)
   {
	   String toPrint = player.getPlayerName() + " die " + die.getNumber() + " Rolled to " + die.toString() ;//add
		
		// final results logged at Level.FINE
		logger.log(Level.FINE, toPrint);
   }

   @Override
   public void playerResult(Player player, DicePair result, GameEngine gameEngine)
   {
	   String toPrint =  player.getPlayerName() + ", *RESULT*: " + result.toString() ;
		
		// final results logged at Level.FINE
		logger.log(Level.FINE, toPrint);
   }

@Override
public void houseDieUpdate(Die die, GameEngine gameEngine) {
	 String toPrint = "House "+ "die " + die.getNumber() + " Rolled to " + die.toString() ;
		
		// final results logged at Level.FINE
		logger.log(Level.FINE, toPrint);
	
}

@Override
public void houseResult(DicePair result, GameEngine gameEngine) {
	
	String toPrint = "House: *RESULT* " + result.toString();
	
	
	logger.log(Level.INFO, toPrint);
	playerPoints(gameEngine);
	
}

  
private void playerPoints(GameEngine gameEngine) {
	
	for (Player player : gameEngine.getAllPlayers()) {
		String toPrint =
				"Final Results\n" + player.toString();
		logger.log(Level.INFO, toPrint);
}
	
}

}
