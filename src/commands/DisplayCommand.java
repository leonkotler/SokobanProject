package commands;

import display.CLIDisplayer;
import levels.Level;

import java.io.IOException;


public class DisplayCommand implements Command {

    private Level levelToDisplay=null;

    public void setLevelToDisplay(Level levelToDisplay) throws IOException{
        if (levelToDisplay==null)
            throw new IOException("Please provide a valid level");

        this.levelToDisplay = levelToDisplay;
    }

    public DisplayCommand(Level levelToDisplay) throws IOException{
        setLevelToDisplay(levelToDisplay);
    }

    public DisplayCommand() {
    }

    @Override
    public void execute() throws IOException{
        CLIDisplayer cliDisplayer = new CLIDisplayer();
        cliDisplayer.setLevelToDisplay(levelToDisplay);
        cliDisplayer.display();
    }
}
