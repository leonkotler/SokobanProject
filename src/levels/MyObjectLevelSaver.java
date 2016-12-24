package levels;

import exceptions.LevelEmptyException;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* MyObjectLevelSaver will save a level in a binary format to a stream */
public class MyObjectLevelSaver implements LevelSaver{

    @Override
    public void saveLevel(Level level, OutputStream stream) throws LevelEmptyException {
        try {
        // checking if the level and it's map are legal
        if (level==null || level.getLevelMap()==null) throw new LevelEmptyException("There is no level to save");

            // writing the level object to the stream
            ObjectOutputStream out = new ObjectOutputStream(stream);
            out.writeObject(level);
            out.close();
            System.out.println("Level (object) writing is done!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
