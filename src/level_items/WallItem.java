package level_items;

import java.io.Serializable;

/* WallItem represents the walls of the level */
public class WallItem extends LevelItem implements Serializable{

    public WallItem() {
        this.isMovable=false;
        this.location = null;
    }

    public WallItem(Location location) {
        this.isMovable=false;
        this.location = location;
    }

    @Override
    public String toString() {
        return "#";
    }

}
