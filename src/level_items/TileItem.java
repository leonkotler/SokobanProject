package level_items;

import java.io.Serializable;

/* TileItem represents the tiles of the level */
public class TileItem extends LevelItem implements Serializable{

    public TileItem() {
        this.isMovable=false;
        this.location = null;
    }

    public TileItem(Location location) {
        this.isMovable=false;
        this.location = location;
    }

    @Override
    public String toString() {
        return " ";
    }
}
