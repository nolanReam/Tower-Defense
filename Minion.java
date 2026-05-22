import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * An enemy that is a bit smaller and moves a bit faster
 */
public class Minion extends Enemy
{   
    private Image sprite;
    
    public Minion(int x, int y){
        super(x, y, 30, 30, 4);
        
        try {
            if (sprite == null) {
                sprite = ImageIO.read(new File("minion.png"));
            }
        } catch (IOException e) {
            System.out.println("Error loading sprite: " + e.getMessage());
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
            g.drawImage(sprite, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            // Fallback in case the image fails to load
            g.setColor(java.awt.Color.CYAN);
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
    }
}
