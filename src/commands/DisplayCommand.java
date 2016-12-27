package commands;

import display.CLIDisplayer;
import levels.Level;

import java.io.IOException;


public class DisplayCommand implements Command {

    private Level levelToDisplay;

    public void setLevelToDisplay(Level levelToDisplay){
        this.levelToDisplay = levelToDisplay;
    }

    public DisplayCommand(Level levelToDisplay) {
        this.levelToDisplay = levelToDisplay;
    }

    public DisplayCommand() {
    }

    @Override
    public void execute() throws IOException,ClassNotFoundException{
        CLIDisplayer cliDisplayer = new CLIDisplayer();
        cliDisplayer.setLevelToDisplay(levelToDisplay);
        cliDisplayer.display();
    }
}
