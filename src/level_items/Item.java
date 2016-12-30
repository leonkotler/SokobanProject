package level_items;

/* Item defines an Item that can be placed in a Level's map */
public interface Item {
    String getType();
    Location getLocation();
    void setLocation(Location location);
}
