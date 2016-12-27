package cli;


import commands.LoadCommand;
import commands.MoveCommand;
import commands.SaveCommand;
import display.CLIDisplayer;
import exceptions.LevelEmptyException;
import levels.*;
import policies.MySokobanPolicy;
import utils.Direction;

import java.io.*;

// Known issues:
//TODO: Exceptions
//TODO: Implement XML support
//TODO: Hash map for the file extensions
//TODO: Create an "Empty" Item

public class TempMain {

    public static void main(String[] args) {

        try {
            MyTextLevelLoader txtLoader = new MyTextLevelLoader();
            Level level = txtLoader.loadLevel(new FileInputStream("C:\\Users\\leonk\\Documents\\JavaCourse\\Sokoban\\misc\\level2.txt"));

            SaveCommand save = new SaveCommand("C:\\Users\\leonk\\Documents\\JavaCourse\\Sokoban\\misc\\level2saved.txt", level);
            save.execute();

            LoadCommand load = new LoadCommand("C:\\Users\\leonk\\Documents\\JavaCourse\\Sokoban\\misc\\level2saved.txt");
            load.execute();

            Level loadedTxtLevel = load.getLoadedLevel();

            CLIDisplayer displayer = new CLIDisplayer(loadedTxtLevel);
            displayer.display();

            MySokobanPolicy policy = new MySokobanPolicy(loadedTxtLevel, Direction.LEFT);

            MoveCommand moveCommand = new MoveCommand(loadedTxtLevel, policy, Direction.LEFT);
            displayer.display();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
