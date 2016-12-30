package commands;

import display.CLIDisplayer;
import display.Displayer;
import levels.Level;

import java.io.IOException;


public class DisplayCommand implements Command {

    protected Displayer displayer=null;

    public DisplayCommand(Displayer displayer) throws IOException {
        setDisplayer(displayer);
    }


    public Displayer getDisplayer() {
        return displayer;
    }

    public void setDisplayer(Displayer displayer) throws IOException {
        if (displayer==null)
            throw new IOException("Please provide a valid displayer");
        this.displayer = displayer;
    }

    public DisplayCommand(Level levelToDisplay,Displayer displayer) throws IOException{
        setDisplayer(displayer);
    }

    public DisplayCommand() {
    }

    @Override
    public void execute() throws IOException{
        displayer.display();
    }
}
