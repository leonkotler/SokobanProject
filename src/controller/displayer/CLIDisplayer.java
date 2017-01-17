package controller.displayer;

import model.data.level.Level;
import model.data.level_item.Tile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CLIDisplayer extends GeneralDisplayer {

    protected OutputStream outStream;

    public CLIDisplayer(Level levelToDisplay, OutputStream out) throws IOException {
        super(levelToDisplay);

        this.outStream = out;
    }

    @Override
    public void display() throws IOException {
        if (levelToDisplay == null)
            throw new IOException("No level to display, try loading one first");
        PrintWriter out = new PrintWriter(outStream);
        for (ArrayList<Tile> list : levelToDisplay.getLevelMap()) {
            for (Tile tile : list) {
                out.print(tile.toString());
            }
            out.println();
            out.flush();
        }
    }
}
