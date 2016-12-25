package display;

import level_items.Tile;
import levels.Level;

import java.util.ArrayList;

public class CLIDisplayer implements Displayer {

    Level levelToDisplay;

    public void setLevelToDisplay(Level levelToDisplay){
        this.levelToDisplay = levelToDisplay;
    }

    public CLIDisplayer(Level levelToDisplay) {
        this.levelToDisplay = levelToDisplay;
    }

    public CLIDisplayer() {}

    @Override
    public void display() {
        for (ArrayList<Tile> list : levelToDisplay.getLevelMap()) {
            for (Tile tile : list){
                System.out.print(tile.toString());
            }
            System.out.println();
        }
    }
}
