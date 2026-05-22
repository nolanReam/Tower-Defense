import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Write a description of class ExtraLife here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExtraLife extends PowerUp
{
    // instance variables - replace the example below with your own
    private Image sprite;

    /**
     * Constructor for objects of class Shotgun
     */
    public ExtraLife(int x, int y)
    {
        super(x, y, 30, 30, 6);
        try {
            if (sprite == null) {
                sprite = ImageIO.read(new File("extraLife.png"));
            }
        } catch (IOException e) {
            System.out.println("Error loading sprite: " + e.getMessage());
        }
    }

    @Override
    public void draw(Graphics g) {
        if (sprite != null) {
            // g.drawImage(image, x, y, width, height, observer)
            g.drawImage(sprite, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            // Fallback in case the image fails to load
            g.setColor(java.awt.Color.GREEN);
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        } 
    }
    
}
