import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Takes two hits to die
 * Explodes when gets a certain distance from the player
 * Extends GameObject and implements its abstract methods.
 */
public class Bomber extends Enemy {
    private static Image baseSprite;
    private static Image damagedSprite;
    private static Image explodedSprite;
    
    private int hits = 0;
    private boolean isTriggered = false;
    private int detonationTimer = 0;
    private final int MAX_DETONATION_TIME = 30; // 0.5 seconds at 60 FPS

    public Bomber(int x, int y) {
        super(x, y, 40, 40, 3);
        
        try {
            if (baseSprite == null) {
                baseSprite = ImageIO.read(new File("bomber1.png"));
                damagedSprite = ImageIO.read(new File("bomber2.png"));
                explodedSprite = ImageIO.read(new File("bomber3.png"));
            }
        } catch (IOException e) {
            System.out.println("Error loading sprites: " + e.getMessage());
        }
    }

    @Override
    public void update() {
        if (!isTriggered) {
            super.update(); // Move down normally
        } else {
            detonationTimer++;
            if (detonationTimer >= MAX_DETONATION_TIME) {
                this.setActive(false); // Pop!
                // Logic to damage player would go here (see GamePanel note below)
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        int currentWidth = getWidth();
        int currentHeight = getHeight();
        int drawX = getX();
        int drawY = getY();

        // If hit once or triggered, grow by 50%
        if (hits == 1 || isTriggered) {
            int growth = 20; 
            currentWidth += growth;
            currentHeight += growth;
            // Shift x/y by half growth to keep the sprite centered
            drawX -= growth / 2;
            drawY -= growth / 2;
        }

        // Logic for which sprite to show
        Image sprite = (detonationTimer > MAX_DETONATION_TIME - 10) ? explodedSprite : 
                       (isTriggered || hits == 1) ? damagedSprite : baseSprite;

        if (sprite != null) {
            g.drawImage(sprite, drawX, drawY, currentWidth, currentHeight, null);
        }
    }

    public void triggerExplosion() {
        if (!isTriggered) {
            isTriggered = true;
        }
    }

    @Override
    public void checkDistance(int playerX, int playerY) {
        double distance = Math.sqrt(Math.pow(playerX - getX(), 2) + Math.pow(playerY - getY(), 2));
        
        // If within 80 pixels, start the fuse
        if (distance < 80 && !isTriggered) {
            triggerExplosion();
        }
    }

    @Override
    public void incHits() {
        hits++;
        if (hits >= 2) {
            triggerExplosion();
        }
    }
}