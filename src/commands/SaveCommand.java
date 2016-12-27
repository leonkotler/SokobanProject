package commands;

import levels.*;
import utils.FilePathUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* SaveCommand saves a level using it's appropriate saver based on the file's extension */
public class SaveCommand implements Command{

    private String filePath;
    private Level levelToSave;

    public String getFilePath() {
        return filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Level getLevelToSave() {
        return levelToSave;
    }

    public void setLevelToSave(Level levelToSave) {
        this.levelToSave = levelToSave;
    }

    public SaveCommand(String filePath, Level levelToSave) {
        this.filePath = filePath;
        this.levelToSave = levelToSave;
    }

    public SaveCommand() {
    }

    @Override
    public void execute() throws IOException,ClassNotFoundException{
        // getting the extension from the file path
        FilePathUtil checker = new FilePathUtil();
        String ext = checker.getExtension(filePath);

        // TODO: Implement an efficient data structure for the extensions
        // decides which saver to use based on the extension
        if (ext==null)
            throw new FileNotFoundException("Please provide a valid extension");
        if (ext.equals("txt")) {
            MyTextLevelSaver txtSaver = new MyTextLevelSaver();
            txtSaver.saveLevel(levelToSave,new FileOutputStream(filePath));
        }
        if (ext.equals("obj")){
            MyObjectLevelSaver objSaver = new MyObjectLevelSaver();
            objSaver.saveLevel(levelToSave,new FileOutputStream(filePath));
        }
    }
}
