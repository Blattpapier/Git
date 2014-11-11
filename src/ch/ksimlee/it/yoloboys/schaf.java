package ch.ksimlee.it.yoloboys;

import java.awt.event.KeyEvent;
import java.util.Set;

import ch.ksimlee.it.yoloboys.InputHandler;

/**
 * This is a spaceship that will be controlled by the player.
 */
public class schaf extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "schaf.png";
	
	private static final int zIndex = 100;
	
	private int speed = 0;

	public schaf(int x, int y) {
		super(100, 100, zIndex, true, FILENAME);
	}
	}

