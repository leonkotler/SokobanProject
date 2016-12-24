package level_items;

import java.io.Serializable;

/* PlayerItem represents the player's character */
public class PlayerItem extends LevelItem implements Serializable{

    public PlayerItem() {
        this.isMovable = true;
        this.location = null;
    }

    public PlayerItem(Location location) {
        this.isMovable = true;
        this.location = location;
    }

    @Override
    public String toString() {
        return "A";
    }
}
