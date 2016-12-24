package level_items;

import java.io.Serializable;

/* The TargetItem represents that target on which the box should be put on */
public class TargetItem extends LevelItem implements Serializable {

    protected Boolean isOnTarget;

    public TargetItem() {
        this.isMovable=false;
        this.location=null;
        this.isOnTarget=false;
    }

    public TargetItem(Location location) {
        this.isMovable=false;
        this.location = location;
        this.isOnTarget=false;
    }

    public Boolean getOnTarget() {
        return isOnTarget;
    }

    public void setOnTarget(Boolean onTarget) {
        isOnTarget = onTarget;
    }

    @Override
    public String toString() {
        return "o";
    }
}
