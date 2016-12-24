package commands;

import display.CLIDisplayer;
import levels.Level;


public class DisplayCommand implements Command {

    private Level levelToDisplay;

    public void setLevelToDisplay(Level levelToDisplay){
        this.levelToDisplay = levelToDisplay;
    }

    @Override
    public void execute() {
        CLIDisplayer cliDisplayer = new CLIDisplayer();
        cliDisplayer.setLevelToDisplay(levelToDisplay);
        cliDisplayer.display();
    }
}
