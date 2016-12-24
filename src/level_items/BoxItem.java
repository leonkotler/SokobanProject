package level_items;

import java.io.Serializable;

/* BoxItem represents the boxes of the level */
public class BoxItem extends LevelItem implements Serializable{

    public BoxItem() {
        this.isMovable=true;
        this.location = null;
    }

    public BoxItem(Location location) {
        this.isMovable=true;
        this.location = location;
    }

    @Override
    public String toString() {
        return "@";
    }
}
