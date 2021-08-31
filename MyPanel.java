package fr.heighties.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	final int PANEL_WIDTH = 200;
	final int PANEL_HEIGHT = 400;
	Image cominter;
	Image affinter;

	MyPanel() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		// this.setLayout(null);
		cominter = new ImageIcon("cominter.png").getImage();
		affinter = new ImageIcon("affinter.jpg").getImage();
		/*
		 * cominter.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		 * cominter.setMaximumSize(cominter.setPreferredSize());
		 */

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(cominter, 0, 300, null);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(cominter, 0, 0, this);
	}

}
