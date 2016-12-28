package commands;

import levels.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/* defines the general functionality of a load/save command */
public abstract class IOcommand implements Command{

    protected String filePath=null;
    protected Level level=null;
    protected HashMap<String, LevelLoader> loaderExtensions=null;
    protected HashMap<String, LevelSaver> saverExtensions=null;

    public IOcommand(String filePath, Level level) throws IOException {
        setFilePath(filePath);
        setLevel(level);
        setDefaultExtension();
    }

    public IOcommand(String filePath) {
        this.filePath = filePath;
    }

    public IOcommand() {
        setDefaultExtension();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws FileNotFoundException {
        if (filePath==null)
            throw new FileNotFoundException("Please provide a valid path");
        this.filePath = filePath;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) throws IOException {
        if (level==null)
            throw new IOException("Please provide a valid level");
        this.level = level;
    }

    protected void setDefaultExtension(){
        loaderExtensions = new HashMap<>();
        loaderExtensions.put("txt",new MyTextLevelLoader());
        loaderExtensions.put("obj",new MyObjectLevelLoader());
        loaderExtensions.put("xml",new MyXMLLevelLoader());

        saverExtensions = new HashMap<>();
        saverExtensions.put("txt", new MyTextLevelSaver());
        saverExtensions.put("obj", new MyObjectLevelSaver());
        saverExtensions.put("xml", new MyXMLLevelSaver());
    }

    public HashMap<String, LevelLoader> getLoaderExtensions() {
        return loaderExtensions;
    }

    public void setLoaderExtensions(HashMap<String, LevelLoader> loaderExtensions) {
        this.loaderExtensions = loaderExtensions;
    }

    public HashMap<String, LevelSaver> getSaverExtensions() {
        return saverExtensions;
    }

    public void setSaverExtensions(HashMap<String, LevelSaver> saverExtensions) {
        this.saverExtensions = saverExtensions;
    }
}
