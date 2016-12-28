package display;

import level_items.Tile;
import levels.Level;

import java.io.IOException;
import java.util.ArrayList;

public class CLIDisplayer extends GeneralDisplayer {

    public CLIDisplayer(Level levelToDisplay) throws IOException {
       super(levelToDisplay);
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
