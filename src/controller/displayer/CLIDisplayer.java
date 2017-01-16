package controller.displayer;

import model.data.level_item.Tile;
import model.data.level.Level;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CLIDisplayer extends GeneralDisplayer {

    OutputStream outStream;

    public CLIDisplayer(Level levelToDisplay, OutputStream out) throws IOException {
       super(levelToDisplay);
       this.outStream=out;
    }

    public CLIDisplayer() {

    }

    @Override
    public void display() {
        PrintWriter out = new PrintWriter(outStream);
        for (ArrayList<Tile> list : levelToDisplay.getLevelMap()) {
            for (Tile tile : list){
               out.print(tile.toString());
            }
            out.println();
        }
    }
}
