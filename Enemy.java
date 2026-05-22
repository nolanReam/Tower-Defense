import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Represents an enemy character that falls from the top of the screen.
 * Extends GameObject and implements its abstract methods.
 */
public class Enemy extends GameObject {
    private int speed; // Speed at which the enemy falls
    private Image sprite;

    /**
     * Constructor for Enemy.
     * @param x The initial x-coordinate.
     * @param y The initial y-coordinate.
     * @param width The width of the enemy.
     * @param height The height of the enemy.
     * @param speed The falling speed of the enemy.
     */
    public Enemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height); // Call superclass constructor
        this.speed = speed;
        try {
            if (sprite == null) {
                sprite = ImageIO.read(new File("enemy.png"));
            }
        } catch (IOException e) {
            System.out.println("Error loading sprite: " + e.getMessage());
        }
    }

    /**
     * Updates the enemy's position, making it fall downwards.
     * Deactivates the enemy if it goes off-screen.
     */
    @Override
    public void update() {
        // Enemies fall from the top, update y-coordinate using inherited setter
        setY(getY() + speed);

        // Deactivate if off-screen (below the bottom of the screen)
        if (getY() > GamePanel.SCREEN_HEIGHT) {
            setActive(false); // Use inherited setter to deactivate
        }
    }

    /**
     * Draws the enemy character on the screen.
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
            g.setColor(java.awt.Color.RED);
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
    }
    
}
