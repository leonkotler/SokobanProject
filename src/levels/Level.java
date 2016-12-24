package levels;

import level_items.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable{

    private ArrayList<ArrayList<Item>> levelMap; // 2D ArrayList that contains items.

    public Level(ArrayList<ArrayList<Item>> levelMap) {
        this.levelMap = levelMap;
    }

    public void setLevelMap(ArrayList<ArrayList<Item>> levelMap) {
        this.levelMap = levelMap;
    }

    public ArrayList<ArrayList<Item>> getLevelMap() {
        return levelMap;
    }

}
