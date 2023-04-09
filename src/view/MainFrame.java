package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import model.interfaces.GameEngine;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private MenuBar menu;
	private DiePanel panel;
	private SummaryPanel summaryPanel;
	private ToolBar toolBar;
	private AddPlayer player;
	private PlayerBox box;
	private StatusBar bar;
	
	public MainFrame() {
		menu = new MenuBar();
		player = new AddPlayer();
		panel = new DiePanel();
		summaryPanel = new SummaryPanel();
		toolBar = new ToolBar();
		box = new PlayerBox();
		bar = new StatusBar();
		bar.repaint();
		MainWindow();
	}
	
	private void MainWindow() {
		this.setJMenuBar(menu);
		this.setLayout(new BorderLayout());
		this.add(toolBar, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.add(summaryPanel, BorderLayout.WEST);
		this.add(bar, BorderLayout.SOUTH);
		this.setFocusable(false);
		this.pack();
		this.setResizable(true);
		this.add(box,BorderLayout.EAST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(725, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("Dice Game");
		this.setVisible(true);
		Dimension sizeOfScreen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMinimumSize(new Dimension(sizeOfScreen.width/2 , sizeOfScreen.height/2));
		}
	
	public void addListeners(GameEngine gameEngine) {
		menu.addListeners(this, gameEngine);
		player.addListeners(this, gameEngine);
		toolBar.addListeners(this, gameEngine);
		panel.repaint();
        panel.setIgnoreRepaint(true);
        box.addListeners(this, gameEngine);
      }

	public SummaryPanel getsummaryPanel() {
		return this.summaryPanel;
	}

	public ToolBar getToolbar() {
		return this.toolBar;
	}
	
	public DiePanel getDiePanel() {
		return this.panel;
	}

	public AddPlayer getAddPlayer() {	
		return this.player;
	}
	
	public PlayerBox getPlayerBox() {	
		return this.box;
	}
	
	public StatusBar getStatusBar() {	
		return this.bar;
	}
	
    public void componentResized(ComponentEvent e) {
    	panel.repaint();
    }
	
}
