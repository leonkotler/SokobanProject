package controller.displayer;

import model.data.level.Level;

import java.io.IOException;

/* defines the general functionality of any displayer */
public abstract class GeneralDisplayer implements Displayer{

    protected Level levelToDisplay=null;

    public GeneralDisplayer(Level levelToDisplay) throws IOException {
        setLevelToDisplay(levelToDisplay);
    }

    public Level getLevelToDisplay() {
        return levelToDisplay;
    }

    public GeneralDisplayer() {
    }

    public void setLevelToDisplay(Level levelToDisplay) throws IOException {
        if (levelToDisplay==null)
            throw new IOException("Please provide a valid level");
        else
            this.levelToDisplay = levelToDisplay;
    }
}
