import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a projectile (e.g., a bullet fired by the player).
 * Extends GameObject and implements its abstract methods.
 */
public class Projectile extends GameObject {
    private int speed; // Speed at which the projectile travels

    /**
     * Constructor for Projectile.
     * @param x The initial x-coordinate.
     * @param y The initial y-coordinate.
     * @param width The width of the projectile.
     * @param height The height of the projectile.
     * @param speed The traveling speed of the projectile.
     */
    public Projectile(int x, int y, int width, int height, int speed) {
        super(x, y, width, height); // Call superclass constructor
        this.speed = speed;
    }

    /**
     * Updates the projectile's position, making it move upwards.
     * Deactivates the projectile if it goes off-screen.
     */
    @Override
    public void update() {
        // Projectiles move upwards, update y-coordinate using inherited setter
        setY(getY() - speed);

        // Deactivate if off-screen (above the top of the screen)
        if (getY() + getHeight() < 0) {
            setActive(false); // Use inherited setter to deactivate
        }
        
        
    }

    /**
     * Draws the projectile on the screen.
     * @param g The Graphics object used for drawing.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW); // Projectiles are yellow
        // Use inherited getters for drawing position and dimensions
        g.fillRect(getX(), getY(), getWidth(), getHeight()); // Draw as a rectangle
        
        
    }
}
