package controller.command;

import model.data.level.Level;
import utils.FilePathUtil;

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

        if (!saverExtensions.containsKey(ext))
            throw new IOException("Please provide a valid file format");
        else
            saverExtensions.get(ext).saveLevel(level,new FileOutputStream(filePath));
    }
}
