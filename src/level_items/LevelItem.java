package level_items;

import java.io.Serializable;

/* The abstract class LevelItem describes the general functionality of each item that inherits it */
public abstract class LevelItem implements Item{

    protected Boolean isMovable;
    protected Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getType(){
        return this.getClass().getName();
    }

    public void setMovable(Boolean movable) {
        isMovable = movable;
    }

    public Boolean getMovable() {
        return isMovable;
    }
}
