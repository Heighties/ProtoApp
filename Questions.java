package fr.heighties.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Questions extends JPanel {

	Questions panel;
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 250;
	Image inter;

	Questions() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		inter = new ImageIcon("cominter.png").getImage();
		this.add(panel);
		this.setVisible(true);

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(inter, 0, 400, null);

	}

}
