package model.data.level_item;

import java.io.Serializable;

/* WallItem represents the walls of the level */
public class WallItem extends LevelItem implements Serializable{


    public WallItem() {
    }

    @Override
    public String toString() {
        return "#";
    }

}
