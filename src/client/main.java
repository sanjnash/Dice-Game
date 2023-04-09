package client;

import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallBackGui;
//import view.GameEngineCallBackGUI;
import view.GameEngineCallbackImpl;
import view.MainFrame;

public class main {

	public static void main(String[] args) {
		final GameEngine gameEngine = new GameEngineImpl();
		
		SwingUtilities.invokeLater(() -> {
			/* View */
			final MainFrame mainFrame = new MainFrame();
			/* Controllers */
			mainFrame.addListeners(gameEngine);
			/* GUI Observer/Callback */
		gameEngine.addGameEngineCallback(new GameEngineCallBackGui(mainFrame));
		});
		
		/* Observer/Callback */
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());


	

	}

}
