package display;

import level_items.Item;
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
        for (ArrayList<Item> list : levelToDisplay.getLevelMap()) {
            for (Item item : list){
                System.out.print(item.toString());
            }
            System.out.println();
        }
    }
}
