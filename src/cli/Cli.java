package cli;

import commands.*;
import display.CLIDisplayer;
import levels.Level;
import levels.LevelLoader;
import policies.MySokobanPolicy;
import utils.Direction;
import utils.FilePathUtil;

import java.io.BufferedReader;
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

    void run() {

        String[] command;

        Level level = null;

        LoadCommand loadCommand = new LoadCommand();
        SaveCommand saveCommand = new SaveCommand();
        DisplayCommand displayCommand = new DisplayCommand();
        MoveCommand moveCommand = new MoveCommand();

        while (!exit) {
            try {
                Scanner scanner = new Scanner(System.in);
                command = scanner.nextLine().split(" ");

                switch (command[0]) {
                    case "load":
                        loadCommand.setFilePath(command[1]);
                        loadCommand.execute();
                        level = loadCommand.getLoadedLevel();
                        System.out.println("Level " + new FilePathUtil().getFileNameFromPath(command[1]) + " loaded successfully");
                        break;
                    case "save":
                        if (level == null)
                            System.out.println("There is no level to save. Try loading one first.");

                        saveCommand.setFilePath(command[1]);
                        saveCommand.setLevelToSave(level);
                        saveCommand.execute();
                        System.out.println("Level " + new FilePathUtil().getFileNameFromPath(command[1]) + " saved successfully");
                        break;
                    case "display":
                        if (level == null)
                            System.out.println("There is no level to display. Try loading one first.");
                        else {
                            displayCommand.setLevelToDisplay(level);
                            displayCommand.execute();
                        }

                        break;
                    case "exit":
                        System.out.println("Exiting");
                        new ExitCommand(this).execute();
                        break;
                    case "move":
                        if (level == null)
                            System.out.println("There is no level to play. Try loading one first.");

                        moveCommand.setLevel(level);
                        moveCommand.setPolicy(new MySokobanPolicy(level, Direction.valueOf(command[1].toUpperCase())));
                        moveCommand.setDirection(Direction.valueOf(command[1].toUpperCase()));
                        moveCommand.execute();
                        displayCommand.execute();

                        break;
                    default:
                        System.out.println("Unrecognizable command, try again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

}
