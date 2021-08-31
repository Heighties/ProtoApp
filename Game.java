package fr.heighties.app;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 7853077890512115282L;

	public static final int WIDTH = 500, HEIGHT = 800;

	private Thread thread;
	private boolean running = false;

	private Menu menu;

	public enum STATE {
		Menu, Game, TestQ, TestR, Questions

	};

	public static STATE gameState = STATE.Menu;

	public Game() {

		menu = new Menu(this);
		this.addMouseListener(menu);

		new Window(WIDTH, HEIGHT, "What The Fuck Comments", this);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// pas besoin de cliquer sur fenetre pour jouer :
		// this.requestFocus();
		//
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

		}
		stop();

	}

	private void tick() {

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;

		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if (gameState == STATE.Game) {

		} else if (gameState == STATE.Menu || gameState == STATE.TestQ || gameState == STATE.TestR) {
			menu.render(g);
		}

		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		new Game();

	}

}
