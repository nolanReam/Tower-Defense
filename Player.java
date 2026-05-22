import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent; // For keyboard input
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Represents the player character in the game.
 * Extends GameObject and implements its abstract methods.
 */
public class Player extends GameObject {
    private int speed; // Player's movement speed
    private int dx;    // Change in x-direction (horizontal movement)
    private Image sprite;
    private int lives;

    /**
     * Constructor for Player.
     * @param x The initial x-coordinate.
     * @param y The initial y-coordinate.
     * @param width The width of the player.
     * @param height The height of the player.
     * @param speed The movement speed of the player.
     */
    public Player(int x, int y, int width, int height, int speed) {
        super(x, y, width, height); // Call superclass constructor
        this.speed = speed;
        this.dx = 0; // Player starts stationary
        this.lives = 1;
        try {
            if (sprite == null) {
                sprite = ImageIO.read(new File("player.png"));
            }
        } catch (IOException e) {
            System.out.println("Error loading sprite: " + e.getMessage());
        }
    }

    /**
     * Updates the player's position based on horizontal movement.
     * Ensures the player stays within screen bounds.
     */
    @Override
    public void update() {
        // Update player's position using inherited setter (setX) and getter (getX)
        setX(getX() + dx);

        // Keep player within screen bounds using GamePanel's constants
        if (getX() < 0) {
            setX(0);
        } else if (getX() + getWidth() > GamePanel.SCREEN_WIDTH) {
            setX(GamePanel.SCREEN_WIDTH - getWidth());
        }
    }

    /**
     * Draws the player character on the screen.
     * @param g The Graphics object used for drawing.
     */
    @Override
    public void draw(Graphics g) {
        // Draw the image instead of the oval
        if (sprite != null) {
            // g.drawImage(image, x, y, width, height, observer)
            g.drawImage(sprite, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            // Fallback in case the image fails to load
            g.setColor(java.awt.Color.BLUE);
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
    }

    /**
     * Handles key press events for player movement.
     * @param keyCode The integer code of the pressed key.
     */
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            dx = -speed; // Move left
        } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            dx = speed;  // Move right
        }
        // Note: Shooting logic (e.g., for VK_SPACE) is handled in GamePanel
    }

    /**
     * Handles key release events to stop player movement.
     * @param keyCode The integer code of the released key.
     */
    public void keyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT ||
            keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D) {
            dx = 0; // Stop horizontal movement when movement key is released
        }
    }

    public int getLives(){
        return lives;
    }
    
    public void addLife(){
        lives++;
    }
    
    public void decLife(){
        lives--;
    }
}
