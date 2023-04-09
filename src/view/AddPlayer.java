package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.AddPlayerController;
import model.interfaces.GameEngine;

public class AddPlayer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// TextFields
	private JTextField nameText;
	private JTextField pointsText;
	private JTextField idText;
	
	//JPlayer AddButton
	private JButton addPlayerBtn;
	
	
	AddPlayer() {
		
		JPanel panel = new JPanel();
		JLabel nameLabel = new JLabel("Player Name: ");
		JLabel pointsLabel = new JLabel("Points:");
		JLabel idLabel = new JLabel("Player ID: ");
		
		nameText = new JTextField(25);
		idText = new JTextField("1",20);
		pointsText = new JTextField("1000", 10);
		addPlayerBtn = new JButton("Add Player");
		addPlayerBtn.setActionCommand("addPlayer");
		
		panel.add(idLabel);
		panel.add(idText);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(pointsLabel);
		panel.add(pointsText);
		panel.add(addPlayerBtn);		
		
		this.getRootPane().setDefaultButton(addPlayerBtn);
		this.add(panel);
		this.setSize(300, 300);
		this.setTitle("AddPlayer in Gui");
	}
	

	public void centerDialogToMainWindow(MainFrame mainFrame) {
		this.setLocationRelativeTo(mainFrame);
	}
	

	void addListeners(MainFrame mainFrame, GameEngine gameEngine) {
		addPlayerBtn.addActionListener(new AddPlayerController(mainFrame, gameEngine));
	}
	

	public String getnameTextText() {
		return this.nameText.getText();
	}
	
	public String getidTextText() {
		return this.idText.getText();
	}
	
	public String getPointFieldText() {
		return this.pointsText.getText();
	}

}
