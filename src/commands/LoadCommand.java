package commands;


import levels.Level;
import levels.MyObjectLevelLoader;
import levels.MyTextLevelLoader;
import utils.FilePathUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* LoadCommand loads a file (supports different extensions) and stores is within itself. The level is accessible through getLoadedLevel() */
public class LoadCommand extends IOcommand{

    public LoadCommand(String filePath) throws IOException {
       super(filePath);
    }

    public LoadCommand() {
    }


    @Override
    public void execute() throws IOException {

        FilePathUtil checker = new FilePathUtil();
        String ext = checker.getExtension(filePath);

//        // TODO: Implement an efficient data structure for the extensions
//
//        // decides which loader to use based on the extension
//        if (ext.equals("txt"))
//            level = new MyTextLevelLoader().loadLevel(new FileInputStream(filePath));
//        else if (ext.equals("obj")) {
//            try {
//                level = new MyObjectLevelLoader().loadLevel(new FileInputStream(filePath));
//            } catch (ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        else
//            throw new IOException("Please provide a valid file format");
        // checking if the extension is valid
        if (!loaderExtensions.containsKey(ext))
            throw new IOException("Please provide a valid file format");
        else
            try {
                level = loaderExtensions.get(ext).loadLevel(new FileInputStream(filePath));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
}
