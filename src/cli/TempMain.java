package cli;


import commands.LoadCommand;
import commands.SaveCommand;
import display.CLIDisplayer;
import exceptions.LevelEmptyException;
import levels.*;

import java.io.*;

//TODO: Implement Saving to files and objects *DONE*
//TODO: Normal exception throwing
//TODO: Implement XML support
//TODO: Test LoadCommand and DisplayCommand

public class TempMain {

    public static void main(String[] args) {

        try {
            MyTextLevelLoader txtLoader = new MyTextLevelLoader();
            Level level = txtLoader.loadLevel(new FileInputStream("C:\\Users\\leonk\\Documents\\JavaCourse\\Sokoban\\misc\\level1.txt"));

            SaveCommand save = new SaveCommand("C:\\Users\\leonk\\Documents\\JavaCourse\\Sokoban\\misc\\level1saved.txt",level);
            save.execute();

            LoadCommand load = new LoadCommand("C:\\Users\\leonk\\Documents\\JavaCourse\\Sokoban\\misc\\level1saved.txt");
            load.execute();

            Level loadedTxtLevel = load.getLoadedLevel();

            CLIDisplayer displayer = new CLIDisplayer(loadedTxtLevel);
            displayer.display();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
