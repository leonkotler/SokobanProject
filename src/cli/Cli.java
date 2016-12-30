package cli;

import commands.*;
import display.CLIDisplayer;
import levels.Level;
import policies.MySokobanPolicy;
import utils.Direction;
import utils.FilePathUtil;

import java.io.IOException;
import java.util.Scanner;

/* CLI allows interaction with the game through commands */
public class Cli {

    protected String[] args;
    protected boolean exit = false;

    public Cli() {
    }

    public Cli(String[] args) {
        this.args = args;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }


    void run() throws IOException {

        String[] command;

        Level level = null;

        // initiating all of the CLI's commands
        LoadCommand loadCommand = new LoadCommand();
        SaveCommand saveCommand = new SaveCommand();
        DisplayCommand displayCommand = new DisplayCommand();
        MoveCommand moveCommand = new MoveCommand();

        while (!exit) {
            // getting a line from the scanner and splitting it on the space char
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine().split(" ");
            // swithcing on the command's name
            switch (command[0]) {
                case "load":
                    loadCommand.setFilePath(command[1]);
                    loadCommand.execute();
                    level = loadCommand.getLevel();
                    displayCommand.setDisplayer(new CLIDisplayer(level));
                    System.out.println("Successfully loaded " + new FilePathUtil().getFileNameFromPath(command[1]));
                    displayCommand.execute();
                    break;
                case "save":
                    if (level == null)
                        System.out.println("There is no level to save. Try loading one first.");
                    else {
                        saveCommand.setFilePath(command[1]);
                        saveCommand.setLevel(level);
                        saveCommand.execute();
                        System.out.println("Level saved successfully to " + new FilePathUtil().getFileNameFromPath(command[1]));
                    }
                    break;
                case "display":
                    if (level == null)
                        System.out.println("There is no level to display. Try loading one first");
                    else {
                        displayCommand.setDisplayer(new CLIDisplayer(level));
                        displayCommand.execute();
                    }
                    break;
                case "exit":
                    System.out.println("Exiting");
                    new ExitCommand(this).execute();
                    break;
                case "move":
                    if (level == null)
                        System.out.println("There is no level to play. Try loading one first");
                    else {
                        // checking if the direction provided is indeed a valid direction
                        if (!moveCommand.isVaildDirection(command[1]))
                            System.out.println("Please provide a valid direction");
                        else {
                            moveCommand.setLevel(level);
                            moveCommand.setPolicy(new MySokobanPolicy(level, Direction.valueOf(command[1].toUpperCase())));
                            moveCommand.setDirection(Direction.valueOf(command[1].toUpperCase()));
                            moveCommand.execute();
                            displayCommand.execute();
                            if (level.isWon()){
                                System.out.println("Congratulations! You've Won!");
                                new ExitCommand(this).execute();
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Unknown command, try again");
                    break;
            }
        }

    }

}
