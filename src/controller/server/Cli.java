package controller.server;

import java.io.*;
import java.util.Observable;
import java.util.Scanner;

public class Cli extends Observable implements ClientHandler {

    public OutputStream outToClient;

    public OutputStream getOutToClient() {
        return outToClient;
    }

    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {

        this.outToClient=outToClient;
        String[] userInput;

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inFromClient)));
        PrintWriter writer = new PrintWriter(outToClient);

        writer.println("Welcome to Sokoban!");
        help(outToClient);

        // getting a line from the scanner and splitting it on the 'space' char
        userInput = scanner.nextLine().split(" ");

        setChanged();
        // sending the user's input to the controller
        notifyObservers(userInput);
    }

    public void help(OutputStream outToClient) {
        // displays the help menu
        PrintWriter writer = new PrintWriter(outToClient);
        writer.println();
        writer.println("    Type \"load fullpath\" to load a level from a file");
        writer.println("    Type \"save fullpath\" to save a level from to file");
        writer.println("    Type \"move direction\" (up,down,left,right) to move the character in the desired direction");
        writer.println("    Type \"exit\" to exit the game");
        writer.println("    Type \"help\" show the help menu");
        writer.println();
        writer.flush();
    }

}

