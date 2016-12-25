package levels;

import exceptions.LevelEmptyException;
import level_items.Tile;

import java.io.*;
import java.util.ArrayList;

/* MyObjectLevelSaver will save a level in a text format to a stream */
public class MyTextLevelSaver implements LevelSaver {

    @Override
    public void saveLevel(Level level, OutputStream stream) throws LevelEmptyException {

        // checking if the level and it's map are legal
        if (level == null || level.getLevelMap() == null) throw new LevelEmptyException("There is no level to save");

        // writing the level to file
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
        for (ArrayList<Tile> list : level.getLevelMap()){
            for (Tile tile : list){
                writer.print(tile.toString());
            }
            writer.println();
        }

        writer.close();
        System.out.println("Level writing (text) to file is done!");


    }
}
