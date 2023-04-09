package client;

import model.DicePairImpl;
import model.DieImpl;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
//import validate.Validator;
import view.GameEngineCallbackImpl;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple console client for FP assignment 1, 2020
 * NOTE: This code will not compile until you have implemented stubs for the supplied interfaces!
 * 
 * You must be able to compile your code WITHOUT modifying this class.
 * Additional testing should be done by copying and extending this class while ensuring this class still works.
 * 
 * @author Caspar Ryan
 * 
 */
public class MyTestClient
{
	 private static final Logger logger = Logger.getLogger(SimpleTestClient.class.getName());
   public static void main(String args[])
   {
      
	   // instantiate the GameEngine so we can make calls
      final GameEngine gameEngine = new GameEngineImpl();

      // call method in Validator.jar to test *structural* correctness
      // just passing this does not mean it actually works .. you need to test yourself!
      // pass false if you want to show minimal logging (pass/fail) .. (i.e. ONLY once it passes)
      Validator.validate(true);

      // create two test players (NOTE: you will need to implement the 3 arg contructor in SimplePlayer)
      Player[] players = new Player[] { new SimplePlayer("1", "The Baller", 2000), new SimplePlayer(
         "2", "The Winner", 4500) };

      // register the callback for notifications (all logging output is done by GameEngineCallbackImpl)
      // see provided skeleton class GameEngineCallbackImpl.java
      gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

      // main loop to add players from our collection
      for (Player player : players)
         gameEngine.addPlayer(player);

      // use the gameEngine to place a bet and roll for each Player
      // testing with placing bet 0.
      for (Player player : gameEngine.getAllPlayers())
      {
        //bet is placed as 0!
    	  gameEngine.placeBet(player, 0);
         gameEngine.rollPlayer(player, 100, 1000, 100, 50, 500, 50);
      }

      // all players have rolled so now house rolls (GameEngineCallBack is
      // called) and results are calculated
      gameEngine.rollHouse(100, 1000, 200, 50, 500, 25);
      for( Player player:players) {
     	  System.out.println("Bet is placed as 0, so it will not have any affect on the points. ");
    	  logger.log(Level.INFO, "Final Player Results:");
     	  logger.log(Level.INFO, player.toString());
       }
      
      // use the gameEngine to place a bet and roll for each Player
      // testing with placing bet 100.
    
      for (Player player : gameEngine.getAllPlayers())
      {
         //bet is placed as 100!
    	  gameEngine.placeBet(player, 100);
        gameEngine.rollPlayer(player, 100, 1000, 100, 50, 500, 50);
       
       }
      
      // all players have rolled so now house rolls (GameEngineCallBack is
      // called) and results are calculated
      System.out.println("Now points will change as bet is placed! ");
      gameEngine.rollHouse(100, 1000, 200, 50, 500, 25);
      
      
     
  //    Testing Equal methods
      DicePair pair = new DicePairImpl();
      Die die = new DieImpl(1,5, Die.NUM_FACES );
      Die die2 = new DieImpl(2, 5, Die.NUM_FACES);
     boolean a = die.equals(die2);
     System.out.println("Should be true: " + a);
     //Testing Hashcodes
     System.out.println("Hashcode should be same: \n" + die.hashCode() + " " + die2.hashCode());
     Die die3 = new DieImpl(1,5, Die.NUM_FACES );
     Die die4 = new DieImpl(2, 4, Die.NUM_FACES);
     System.out.println("Hashcode should be different: \n" + die3.hashCode() + " " + die4.hashCode());
     boolean y = die3.equals(die4);
     System.out.println("Should be false: " + y);
     Player p = new SimplePlayer("1" , "The Cobra", 100);
     p.setResult(pair);
   
 
	   //Testing adding player
	 	System.out.println("Adding Player with id = 1");  
	 	gameEngine.addPlayer(p);
	 	for(Player plyaer: gameEngine.getAllPlayers()) {
		System.out.println(plyaer.toString());
	  
	  //Testing GetPlayer method
		System.out.println("Testing Get Player! Will Only Print with id = 2");
		System.out.println(gameEngine.getPlayer("2"));
	   }
	   
	   //Testing Placebet
	   gameEngine.placeBet(p, 100);
	   System.out.println("Bet has been placed!");
	   System.out.println(p.toString());
	   for(Player plyaer: gameEngine.getAllPlayers()) {
		   gameEngine.placeBet(plyaer, 100);
	   }
	   
	   //Testing Removing player
	   System.out.println("Testing removing player");
	   gameEngine.removePlayer(p);
	   
	   for(Player plyaer: gameEngine.getAllPlayers()) {
		   System.out.println("Player = The Cobra, should be removed.");
		   System.out.println(plyaer.toString());
		 }
	   
	  
	 
   }  
  
}
