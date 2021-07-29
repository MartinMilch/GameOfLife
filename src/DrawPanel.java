
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private GameOfLife gameOfLife;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		gameOfLife.drawRaster(g,  getHeight(), getWidth());
	}

	DrawPanel(GameOfLife gameOfLife) {

		this.gameOfLife = gameOfLife;
		
		 addMouseListener(new MouseAdapter() {

             @Override
             public void mousePressed(MouseEvent e) {
            	 gameOfLife.randomRaster();
             }
         });
		
	}
}