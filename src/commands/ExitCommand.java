package commands;

import cli.Cli;

import java.io.IOException;

public class ExitCommand implements Command{

    Cli cli=null;

    public Cli getCli() {
        return cli;
    }

    public void setCli(Cli cli) throws IOException {
        if (cli==null)
            throw new IOException("Please provide a valid cli");
        this.cli = cli;
    }

    public ExitCommand(Cli cli) throws IOException {
        setCli(cli);
    }

    @Override
    public void execute() throws IOException{
        cli.setExit(true);
    }
}
