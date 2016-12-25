package levels;

import level_items.Location;
import level_items.Tile;

import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable{


    protected ArrayList<ArrayList<Tile>> levelMap; // 2D ArrayList that contains items
    protected Location playerLocation;             // holds the current player location
    protected ArrayList<Tile> targets;             // holds the targets

    public Level(ArrayList<ArrayList<Tile>> levelMap) {
        this.levelMap = levelMap;
        initData();
    }


    public Level() {}

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

    // iterates through the level's map and extracts the player's location and targets
    public void initData(){
        for (ArrayList<Tile> row : levelMap){
            for(Tile tile : row){
                if (tile.getContains()!=null) { // checking if the tile contains anything
                    if (tile.getContains().getType().equals("PlayerItem"))
                        setPlayerLocation(tile.getLocation()); // adding the player's location
                    if (tile.getClass().toString().equals("TargetTile"))
                        targets.add(tile); // adding the tile to the targets array
                }
            }
        }
    }

    public boolean isWon(){
        // checks if every target has a box in it
        boolean win = true;

        for (Tile tile : targets)
            if(tile.getContains()!=null)
                if (!tile.getContains().getType().equals("BoxItem"))
                    win = false;

        return win;
    }
}
