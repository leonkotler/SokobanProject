package level_items;

import java.io.Serializable;

/* The TargetTile represents that target on which the box should be put on */
public class TargetTile extends Tile implements Serializable {

    public TargetTile(Location location) {
        super(location);
    }

    @Override
    public String toString() {
        // if the target contains any other item, then it gets displayed, otherwise - display "o"
        if (contains==null)
            return "o";
        else
            return contains.toString();
    }
}
