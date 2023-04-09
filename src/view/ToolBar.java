package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import controller.ToolBarController;
import model.interfaces.GameEngine;


public class ToolBar extends JToolBar{
	

	private static final long serialVersionUID = 1L;
	

	//JButtons
	private JButton Roll,
	bet,
	cancelBet;
	//TextField
	private JTextField betText;
	
	//Adding Buttons inside the toolBar
	public ToolBar() {
		JLabel title = new JLabel("Dice Game");
		title.setFont(new Font(null, Font.BOLD, 24));
		title.setFocusable(false);
		this.addSeparator(new Dimension(5, 0));
		this.add(title);

		betText = new JTextField("");
		betText.setEditable(false);
		betText.setMinimumSize(new Dimension(50,50));
		betText.setMaximumSize(new Dimension(70,70));
		betText.setFont(new Font(null, Font.PLAIN, 14));
		betText.setHorizontalAlignment(SwingConstants.CENTER);
		
		bet = new JButton("Place bet");
		bet.setActionCommand("placeBet");
		setBetInputEnabled(false);
		
		Roll = new JButton("Roll");
		Roll.setActionCommand("Roll");
		setRollButton(false);
		
		cancelBet = new JButton("Cancel Bet");
		cancelBet.setActionCommand("cancelBet");
		setCancelButton(false);
		
		this.addSeparator(new Dimension(30, 0));
		this.add(Roll, BorderLayout.NORTH);
		this.add(bet);
		this.add(betText);
		this.add(cancelBet);
		}

	//Setter for Bet TextField
	public void setbet(String i) {
		i = "0";
		betText.setText(i);
	}

	//Adding Listener For the ToolBar controller
	public void addListeners(MainFrame mainFrame, GameEngine gameEngine) {
		ToolBarController listener = new ToolBarController(mainFrame, gameEngine);
		Roll.addActionListener(listener);
		betText.addKeyListener(listener);
		bet.addActionListener(listener);	
		cancelBet.addActionListener(listener);
	}

	//Setter For Roll Button 
	public void setRollButton(boolean enable) {
		Roll.setEnabled(enable);
		Roll.setFocusable(enable);
		
	}
	
	//Setter For Cancel Button
	public void setCancelButton(boolean enable) {
		cancelBet.setEnabled(enable);
		cancelBet.setFocusable(enable);
	}
	
	//Getter for Bet text
	public String getBetText() {
		return betText.getText();
	}
	
	//Clears bet Text
	public void clearBetText() {
		betText.setText("");
	}
	
	//Setter For Bet Button
	public void setBetInputEnabled(boolean enable) {
		bet.setEnabled(enable);
		bet.setFocusable(enable);
		betText.setEditable(enable);
		betText.setFocusable(enable);
	}

}
