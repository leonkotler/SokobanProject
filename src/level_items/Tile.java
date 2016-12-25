package level_items;

import java.io.Serializable;

/* Tile represents the tiles of the level */
public class Tile implements Serializable{

    // can hold any item inside of it
    protected Item contains;
    protected Location location;


    public Tile() {
        this.location = null;
        this.contains=null;
    }

    public Tile(Location location) {
        this.location = location;
    }

    public Tile(Location location, Item contains) {
        this.location = location;
        this.contains = contains;
    }

    public Item getContains() {
        return contains;
    }

    public void setContains(Item contains) {
        this.contains = contains;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isEmpty(){
        return (contains==null);
    }
    public void freeTile(){
        setContains(null);
    }

    @Override
    public String toString() {
        // if the tile contains any other item, then it gets displayed, otherwise - display blank space;
        if (contains==null)
            return " ";
        else
            return contains.toString();
    }
}