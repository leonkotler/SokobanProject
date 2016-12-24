package commands;

import exceptions.LevelEmptyException;
import levels.*;
import utils.FilePathUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

    @Override
    public void execute() {
        // getting the extension from the file path
        FilePathUtil checker = new FilePathUtil();
        String ext = checker.getExtension(filePath);

        // TODO: Implement an efficient data structure for the extensions
        // decides which saver to use based on the extension
        if (ext.equals("txt")) {
            MyTextLevelSaver txtSaver = new MyTextLevelSaver();
            try {
                txtSaver.saveLevel(levelToSave,new FileOutputStream(filePath));
            } catch (LevelEmptyException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (ext.equals("obj")){
            MyObjectLevelSaver objSaver = new MyObjectLevelSaver();
            try {
                objSaver.saveLevel(levelToSave,new FileOutputStream(filePath));
            } catch (LevelEmptyException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
