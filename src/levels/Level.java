package levels;

import level_items.Location;
import level_items.Tile;
import utils.Direction;

import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {


    protected ArrayList<ArrayList<Tile>> levelMap; // 2D ArrayList that contains items
    protected Location playerLocation;             // holds the current player location
    protected ArrayList<Tile> targets;             // holds the targets
    protected int xLenght;                         // level dimensions
    protected int yWidth;

    public int getxLenght() {
        return xLenght;
    }

    public void setxLenght(int xLenght) {
        this.xLenght = xLenght;
    }

    public int getyWidth() {
        return yWidth;
    }

    public void setyWidth(int yWidth) {
        this.yWidth = yWidth;
    }

    public Level(ArrayList<ArrayList<Tile>> levelMap) {
        this.levelMap = levelMap;
        initData();
    }

    public Level() {
    }

    public void setLevelMap(ArrayList<ArrayList<Tile>> levelMap) {
        this.levelMap = levelMap;
    }

    public ArrayList<ArrayList<Tile>> getLevelMap() {
        return levelMap;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public ArrayList<Tile> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Tile> targets) {
        this.targets = targets;
    }

    public void initData() {
        targets = new ArrayList<>();

        // setting the level's dimensions
        xLenght = levelMap.size();
        yWidth = levelMap.get(0).size();

        // iterates through the level's map and extracts the player's location and targets
        for (ArrayList<Tile> row : levelMap) {
            if (row.size()>yWidth)
                yWidth=row.size();
            for (Tile tile : row) {
                if (tile.toString().equals("o"))
                    targets.add(tile); // adding the tile to the targets array
                if (tile.toString().equals("A"))
                    setPlayerLocation(tile.getLocation()); // adding the player's location
                }
            }
    }

    public void moveItem(Location to, Location from) {
        // moves the Item in the provided location to the provided location
        levelMap.get(to.getX()).get(to.getY())
                .setContains(levelMap.get(from.getX()).get(from.getY()).getContains());
        // setting the from tile to contain nothing
        levelMap.get(from.getX()).get(from.getY()).freeTile();
    }

    public boolean isWon() {
        // checks if every target has a box in it
        boolean win = true;

        for (Tile tile : targets)
            if (tile.getContains() != null)
                if (!tile.getContains().getType().equals("BoxItem"))
                    win = false;

        return win;
    }
}
