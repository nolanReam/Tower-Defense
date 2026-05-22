import java.awt.Graphics;
import java.awt.Rectangle; // Useful for collision detection

/**
 * The abstract base class for all game entities.
 * Defines common properties and behaviors that all game objects share.
 * Subclasses must implement the abstract update() and draw() methods.
 */
public abstract class GameObject {
    // Private instance variables for encapsulation
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean active; // Indicates if the object is still in play

    /**
     * Constructor for GameObject.
     * @param x The x-coordinate of the object's top-left corner.
     * @param y The y-coordinate of the object's top-left corner.
     * @param width The width of the object.
     * @param height The height of the object.
     */
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.active = true; // Objects are active by default upon creation
    }

    /**
     * Abstract method to define how the object updates its state each frame.
     * Subclasses MUST implement this method.
     */
    public abstract void update();

    /**
     * Abstract method to define how the object draws itself on the screen.
     * Subclasses MUST implement this method.
     * @param g The Graphics object used for drawing.
     */
    public abstract void draw(Graphics g);

    // --- Accessor (Getter) Methods ---
    /**
     * Returns the x-coordinate of the object.
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the object.
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the width of the object.
     * @return The width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the object.
     * @return The height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Checks if the object is active (in play).
     * @return true if active, false otherwise.
     */
    public boolean isActive() {
        return active;
    }
    
    public void incHits(){
    }
    
    public int getHits(){
        return 0;
    }
    
    public void addHits(){
    }
    
    public void decLife(){
    }
    
    public void addLife(){
    }
    
    public void incBulletSize(){
    }
    
    public void setWidth(int newWidth){
        width = newWidth;
    }
    
    public void setHeight(int newHeight){
        height = newHeight;
    }
    
    public int getLives(){
        return 0;
    }
    
    public void checkDistance(int playerX, int playerY){
    }

    // --- Mutator (Setter) Methods ---
    /**
     * Sets the x-coordinate of the object.
     * @param x The new x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the object.
     * @param y The new y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the active status of the object.
     * @param active The new active status.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Returns a Rectangle object representing the object's bounding box.
     * Useful for collision detection.
     * @return A Rectangle representing the object's bounds.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
