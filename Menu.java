package fr.heighties.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import fr.heighties.app.Game.STATE;

public class Menu extends MouseAdapter {

	public static final int WIDTH = 500, HEIGHT = 800;

	private Game game;
	// Image cominter = new ImageIcon("cominter");
	// Image cominter = new
	// ImageIcon(this.getClass().getResource("cominter.PNG")).getImage();
	Image cominter = new ImageIcon("cominter.png").getImage();
	Image affinter = new ImageIcon("affinter.jpg").getImage();

	public Menu(Game game) {
		this.game = game;

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (game.gameState == STATE.Menu) {

			// play button

			if (mouseOver(mx, my, 150, 150, 200, 64)) {
				game.gameState = STATE.Game;

			}
			// test button
			if (mouseOver(mx, my, 150, 250, 200, 64)) {
				game.gameState = STATE.TestQ;

			}

			// quit button
			if (mouseOver(mx, my, 150, 350, 200, 64)) {
				System.exit(1);

			}
		}
		if (game.gameState == STATE.TestQ) {
			if (mouseOver(mx, my, 150, 500, 200, 64)) {
				game.gameState = STATE.Menu;
				return;

			}
			if (mouseOver(mx, my, 0, 250, 500, 137)) {
				game.gameState = STATE.TestR;
				return;

			}

		}
		if (game.gameState == STATE.TestR) {
			if (mouseOver(mx, my, 150, 500, 200, 64)) {
				game.gameState = STATE.TestQ;
				return;
			}

		}

	}

	public void mouseReleased(MouseEvent e) {

	}

	// souris dans rectangles

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;

	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (game.gameState == STATE.Menu) {

			g.setColor(new Color(254, 204, 0));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			g.fillRect(0, 130, WIDTH, HEIGHT);

			Font fnt = new Font("arial,Sans-Serif", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);

			g.setFont(fnt);

			g.setColor(Color.black);
			g.drawString("What The Fuck", 60, 70);
			g.drawString("Comments", 115, 115);

			g.setFont(fnt2);

			g.drawRect(150, 150, 200, 64);
			g.drawString("Play", 225, 190);

			g.drawRect(150, 250, 200, 64);
			g.drawString("Test", 225, 290);

			g.drawRect(150, 350, 200, 64);
			g.drawString("Quit", 225, 390);

		} else if (game.gameState == STATE.TestQ) {

			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.black);
			g.drawString("Test", 190, 70);

			// hauteur et largeur de l'image
			cominter.getHeight(game);
			cominter.getWidth(game);

			/*
			 * if (cominter.getWidth(game) > game.getWidth()) cominter.getWidth(game) ==
			 * game.getWidth();
			 */

			g.drawImage(cominter, 0, 250, game.getWidth(),
					(cominter.getHeight(game) * game.getWidth() / cominter.getWidth(game)), game);

			System.out.println(cominter.getHeight(game));
			System.out.println(cominter.getWidth(game));
			// Comment redimensionner l'image par rapport à game.width

			// Image com1 = new
			// ImageIcon(this.getClass().getResource("cominter.PNG")).getImage();

			g.setFont(fnt2);
			g.drawRect(150, 500, 200, 64);
			g.drawString("Back", 220, 540);

		}
		if (game.gameState == STATE.TestR) {

			g.drawImage(affinter, 50, 50, 388, 500, game);

			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.black);
			g.drawString("Réponse", 190, 70);

			g.setFont(fnt2);
			g.drawRect(150, 500, 200, 64);
			g.drawString("Back", 220, 540);

		}

	}

}