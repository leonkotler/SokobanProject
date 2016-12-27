package commands;

import cli.Cli;

import java.io.IOException;

public class ExitCommand implements Command{

    Cli cli;

    public Cli getCli() {
        return cli;
    }

    public void setCli(Cli cli) {
        this.cli = cli;
    }

    public ExitCommand(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void execute() throws IOException,ClassNotFoundException{
        if (cli!=null)
            cli.setExit(true);
    }
}
