package levels;

import level_items.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* MyTextLevelLoader will return a level from a file input stream */
public class MyTextLevelLoader implements LevelLoader{

    @Override
    public Level loadLevel(InputStream stream) throws IOException{

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(stream));
        ArrayList<ArrayList<Item>> levelMap = new ArrayList<>();
        levelMap.add(new ArrayList<Item>());

        // variables for iterating through the 2d ArrayList
        int outerIndex=0;
        int innerIndex=0;
        int c;

            while ((c = fileReader.read())!=-1){ // while not end of stream
                char character = (char)c;
                    switch (character){
                        // for each char we'll add it's represented item
                        case '#':
                            levelMap.get(outerIndex).add(innerIndex,new WallItem(new Location(outerIndex,innerIndex)));
                            innerIndex++;
                            break;
                        case '@':
                            levelMap.get(outerIndex).add(innerIndex,new BoxItem(new Location(outerIndex,innerIndex)));
                            innerIndex++;
                            break;
                        case ' ':
                            levelMap.get(outerIndex).add(innerIndex,new TileItem(new Location(outerIndex,innerIndex)));
                            innerIndex++;
                            break;
                        case 'A':
                            levelMap.get(outerIndex).add(innerIndex,new PlayerItem(new Location(outerIndex,innerIndex)));
                            innerIndex++;
                            break;
                        case 'o':
                            levelMap.get(outerIndex).add(innerIndex,new TargetItem(new Location(outerIndex,innerIndex)));
                            innerIndex++;
                            break;
                        case '\n':
                            outerIndex++;
                            innerIndex=0;
                            levelMap.add(new ArrayList<Item>());
                            break;
                    }
            }

        // creating and returning our new level with the map we've received
        Level level = new Level(levelMap);

        return level;
    }
}

