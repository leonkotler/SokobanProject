package levels;

import java.io.IOException;
import java.io.InputStream;

/* LevelLoader defines an interface for loading a level from a given input stream */

public interface LevelLoader {
    Level loadLevel(InputStream stream) throws IOException;
}
