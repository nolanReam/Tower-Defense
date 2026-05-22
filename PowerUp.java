
/**
 * Write a description of class PowerUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class PowerUp extends GameObject
{
    private int speed;
    
    /**
     * Constructor for objects of class PowerUp
     */
    public PowerUp(int x, int y, int width, int height, int speed)
    {
        super(x, y, width, height);
        this.speed = speed; // ADD THIS LINE so they actually fall!
    }
    
    @Override
    public void update() {
        // Enemies fall from the top, update y-coordinate using inherited setter
        setY(getY() + speed);

        // Deactivate if off-screen (below the bottom of the screen)
        if (getY() > GamePanel.SCREEN_HEIGHT) {
            setActive(false); // Use inherited setter to deactivate
        }
    }
}
