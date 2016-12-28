package level_items;

/* The abstract class LevelItem describes the general functionality of each item that inherits it */
public abstract class LevelItem implements Item{

    public String getType(){
        return this.getClass().getSimpleName();
    }

}
