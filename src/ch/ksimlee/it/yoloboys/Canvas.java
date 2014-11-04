package ch.ksimlee.it.yoloboys;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Canvas extends JPanel {
	// This variable stores the size of the canvas (in pixel).
	private Dimension SIZE = new Dimension(1920, 1080);
	// This variable stores with how many frames per second (FPS) the canvas
	// should be redrawn.
	private int Counter = 0;
	private long aktuelleSekunde = 0;
	private int lastFPS = 0;
	private static final int FPS = 40;
private Game game;

	public Canvas(Game game) {
		this.game=game;
		setPreferredSize(SIZE);
		Log.info("Initialized canvas.");
		/*
		 * The class timer (from swing) can be used to call a function
		 * periodically. The first argument specifies the frequency in
		 * milliseconds with which the function will be called, and the second
		 * argument an object of type "ActionListener" from which the function
		 * "actionPerformed" will be called with the specified frequency.
		 */
		Timer timer = new Timer((int) (1000.0 / FPS), new ActionListener() {
			// This function is called with the specified frequency.
			@Override
			public void actionPerformed(ActionEvent e) {
				// Repaint the canvas object.
				Canvas.this.repaint();
			}
		});
		// As the timer should immediately start to work, we start it here.
		timer.start();
		Log.info("Drawing timer started.");
	}

	// This function draws this canvas (it draws the JPanel).
	public void paintComponent(Graphics g) {
		Log.debug("Painting the canvas.");
		// Let the swing framework do it's drawing of the JPanel first.
		super.paintComponent(g);
		// The following two commands draw the background:
		// Set the color of the "pen". This color will be used in the following
		// drawing commands.

		// Draw a rectangle with the size of the canvas. Therefore, this draws a
		// "background".
			g.drawRect(0, 0, 2000, 1100);
			g.setColor(Color.red);
			g.fillRect(0, 0, 2000, 1100);
			g.drawRect(500, 500, 100, 200);
			g.setColor(Color.white);
			g.fillRect(820, 80, 220, 800);
			g.fillRect(532, 370, 800, 220);
			g.setColor(Color.black);
			for(RenderObject object: this.game.getObjectsToRender())
			{
				object.render(g);
			}
		
		long now = System.currentTimeMillis()/1000;
		if (now > aktuelleSekunde){
			aktuelleSekunde = now;
			lastFPS = Counter;
			Counter = 0;
		}else {
			Counter = Counter+1;
		}
		g.drawString(""+lastFPS, 50, 50);
		// TODO: Add more drawing commands here.
	}
}