package commands;


import levels.Level;
import levels.MyObjectLevelLoader;
import levels.MyTextLevelLoader;
import utils.FilePathUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* LoadCommand loads a file (supports different extensions) and stores is within itself. The level is accessible through getLoadedLevel() */
public class LoadCommand implements Command {

    private String filePath;
    private Level loadedLevel;

    public LoadCommand(String filePath) {
        this.filePath = filePath;
    }

    public LoadCommand() {
    }

    public Level getLoadedLevel() {
        return loadedLevel;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public void execute() {

        // TODO: Implement an elegan solution for breaking out
//        if (filePath==null) {
//
//        }

        // getting the extension from the file path
        FilePathUtil checker = new FilePathUtil();
        String ext = checker.getExtension(filePath);

        // TODO: Implement an efficient data structure for the extensions
        // decides which loader to use based on the extension
        if (ext.equals("txt")) {
            try {
                loadedLevel = new MyTextLevelLoader().loadLevel(new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ext.equals("obj")) {
            try {
                loadedLevel = new MyObjectLevelLoader().loadLevel(new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }
}
