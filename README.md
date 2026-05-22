# Cosmic Defender

An object-oriented 2D retro arcade space shooter built entirely in Java using native structural paradigms (`java.awt` and `javax.swing`). The project showcases scalable architecture design patterns, polymorphic entity handling, real-time collision spaces, and localized coordinate physics matrices.

## 🛠️ System Architecture & Mechanics

The engine is engineered around standard game loop inheritance to achieve low-overhead frame updates and strict encapsulation of state behaviors.

* **Abstract Entity Management Framework (`GameObject`):** The foundational base class exposes standardized tracking vectors (`x`, `y`, `width`, `height`), rendering hooks, state flags (`active`), and native bounding box vectors (`java.awt.Rectangle`) to handle axis-aligned structural collision detection natively.
* **Polymorphic Enemy Core (`Enemy`):** Leverages structural inheritance to drive specialized vector threat matrices:
  * **Assault Minions (`Minion`):** Scaled-down asset signatures tracking at increased base velocity coefficients to disrupt player positional states.
  * **Proximity-Triggered Exploding Bombers (`Bomber`):** High-health armor blocks that track real-time Euclidean distance relative to the player capsule. Once localized tracking falls inside an 80-pixel radius, a timed detonation sequence initiates, expanding the sprite profile centered over its origin coordinate.
* **Dynamic Physics Drops (`PowerUp`):** An abstract tracking loop handles downward-accelerating modifier entities. The system dynamically changes player capability records at the sub-pixel level, dropping armor recharges (`ExtraLife`) or weapon scaling arrays (`BigBullet`) directly into the running play space.
* **Player Controller System (`Player`):** Encapsulates responsive keyboard tracking routines mapping directly to discrete horizontal velocity states (`dx`), bound precisely within structural display dimensions.

## 💻 Technical Implementation Details

```java
// Real-time Euclidean proximity detection loop inside Bomber class
@Override
public void checkDistance(int playerX, int playerY) {
    double distance = Math.sqrt(Math.pow(playerX - getX(), 2) + Math.pow(playerY - getY(), 2));
    
    // Trigger fuse sequence when target breaks perimeter boundary
    if (distance < 80 && !isTriggered) {
        triggerExplosion();
    }
}
