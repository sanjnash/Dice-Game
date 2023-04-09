package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import controller.DicePanelController;
import model.interfaces.GameEngine;

public class DiePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Initial values of the Dices
	private int die1 = 6;  
	private int die2 = 5;
	JPanel dicePanel;
	Graphics g;
	
	// Timer For Animation
	private Timer timer;   
	
	// Adding things inside the JPanel
	public DiePanel() {
	      setLayout(new BorderLayout(1,1));
	      setBackground(Color.RED); 
	      setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	      
	       dicePanel = new JPanel() {
	      public void paintComponent(Graphics g) { 
	            super.paintComponent(g);  
	            drawDie(g, die1, 10, 55); 
	            drawDie(g, die2, 320, 55);
	            getPreferredSize();
	         }
	      };
	      
	      add(dicePanel, BorderLayout.CENTER);
	      dicePanel.setBackground(Color.GRAY);
	      dicePanel.repaint();
	      dicePanel.validate();
	      
	    } 

		   void drawDie(Graphics g, int val, int x, int y) {
		   	  int v = getWidth();
		      int r = getHeight();  
		   	  g.setColor(Color.white);
		      g.fillRect(x, y, (int) (v*0.35), (int) (v*0.20));
		      g.setColor(Color.black);
		      g.drawRect(x, y, (int) (v*0.35), (int) (v*0.20));
		      if (val > 1)  
		         g.fillOval((int) (x+v*0.03), (int) (y+r*0.03), (int) (v*0.09), (int) (r*0.09));
		      if (val > 3) 
		         g.fillOval((int) (x+v*0.23), (int) (y+r*0.03), (int) (v*0.09), (int) (r*0.09));
		      if (val == 6) 
		         g.fillOval((int) (x+v*0.03), (int) (y+r*0.13), (int) (v*0.09), (int) (r*0.09));
		      if (val % 2 == 1) 
		         g.fillOval((int) (x+v*0.13), (int) (y+r*0.13), (int) (v*0.09), (int) (r*0.09));
		      if (val == 6) 
		         g.fillOval((int) (x+v*0.23), (int) (y+r*0.13), (int) (v*0.09), (int) (r*0.09));
		      if (val > 3) 
		         g.fillOval((int) (x+v*0.03), (int) (y+r*0.23), (int) (v*0.09), (int) (r*0.09));
		      if (val > 1) 
		         g.fillOval((int) (x+v*0.23), (int) (y+r*0.23), (int) (v*0.09), (int) (r*0.09));
		   }
		   
		   
//	   
//	    Rolling Animation
	 	public void roll(int i, int j) {
	 	timer = null;
	 	if (timer != null)
	         return;
	      timer = new Timer(100, new ActionListener() {
	         int frames = 1;
	         public void actionPerformed(ActionEvent evt) {
	            die1 = i;
	            die2 = j;
	            frames++;
	            repaint();
	            if (frames == 1000) {
	            timer = null;
	            timer.stop();
	            }
	            
	         }
	      });
	      timer.start();
	     }

	 	
	 	// Listener For DiePanel
	   void addListeners(MainFrame mainFrame, GameEngine gameEngine) {
		   this.addComponentListener(new DicePanelController(mainFrame, gameEngine));
		}
	   
	   // Resizes Graphics
	   @Override
	   protected void paintComponent(Graphics g)
	   {
	      super.paintComponent(g);
	   }




	}
