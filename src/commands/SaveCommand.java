package commands;

import levels.Level;
import levels.MyObjectLevelSaver;
import levels.MyTextLevelSaver;
import utils.FilePathUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* SaveCommand saves a level using it's appropriate saver based on the file's extension */
public class SaveCommand extends IOcommand{

    public SaveCommand(String filePath, Level level) throws IOException {
        super(filePath,level);
    }

    public SaveCommand() {
    }

    @Override
    public void execute() throws IOException{
        // getting the extension from the file path
        FilePathUtil checker = new FilePathUtil();
        String ext = checker.getExtension(filePath);

//        // TODO: Implement an efficient data structure for the extensions
//        // decides which saver to use based on the extension
//        if (ext.equals("txt")) {
//            MyTextLevelSaver txtSaver = new MyTextLevelSaver();
//            txtSaver.saveLevel(level,new FileOutputStream(filePath));
//        }
//        else if (ext.equals("obj")){
//            MyObjectLevelSaver objSaver = new MyObjectLevelSaver();
//            objSaver.saveLevel(level,new FileOutputStream(filePath));
//        }
//        else
//            throw new IOException("Please provide a valid file format");
        // checking if it's a supported exception
        if (!saverExtensions.containsKey(ext))
            throw new IOException("Please provide a valid file format");
        else
            saverExtensions.get(ext).saveLevel(level,new FileOutputStream(filePath));
    }
}
