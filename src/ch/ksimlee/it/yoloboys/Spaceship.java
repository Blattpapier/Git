package ch.ksimlee.it.yoloboys;

import java.awt.event.KeyEvent;
import java.util.Set;

import ch.ksimlee.it.yoloboys.InputHandler;

/**
 * This is a spaceship that will be controlled by the player.
 */
public class Spaceship extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "blocher.png";
	
	private static final int zIndex = 100;
	
	private int speed = 25;

	public Spaceship(int x, int y) {
		super(850, 400, zIndex, true, FILENAME);
	}

	@Override
	public void update(InputHandler currentInput, Set<RenderObject> allObjects) {
		
		// Check if we need to move left.
		if (currentInput.isKeyPressed(KeyEvent.VK_A) ||
				currentInput.isKeyPressed(KeyEvent.VK_LEFT)) {
			
			move(-speed, 0, allObjects);
		}
		
		// Check if we need to move right.
		if (currentInput.isKeyPressed(KeyEvent.VK_D) ||
				currentInput.isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			move(speed, 0, allObjects);
		}
		if (currentInput.isKeyPressed(KeyEvent.VK_W) ||
				currentInput.isKeyPressed(KeyEvent.VK_UP)) {
			
			move(0, -speed, allObjects);
		}
		if (currentInput.isKeyPressed(KeyEvent.VK_S) ||
				currentInput.isKeyPressed(KeyEvent.VK_DOWN)) {
			
			move(0, speed, allObjects);
		}
	}

}