package controller;

import controller.displayer.CLIDisplayer;
import controller.command.*;
import controller.server.MyServer;
import model.Model;
import utils.Direction;
import view.View;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class MyController implements Controller {

    protected Model model;
    protected View view;
    protected BlockingQueue<Command> queue = new ArrayBlockingQueue<Command>(1024);
    protected HashMap<String, Command> commands;
    protected MyServer server;
    boolean run = true;

    public void setServer(MyServer server) {
        this.server = server;
    }

    public MyServer getServer() {
        return server;
    }

    public MyController(Model model, View view) throws IOException {
        this.model = model;
        this.view = view;

        commands = new HashMap<>();
        commands.put("load", new LoadCommand());
        commands.put("save", new SaveCommand());
        commands.put("display", new DisplayCommand());
        commands.put("move", new MoveCommand());
        commands.put("exit", new ExitCommand(this));
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == view) {

        }

        if (o == model) {
            Command command = commands.get((String) arg);
            switch (command.getClass().getSimpleName()) {
                case "DisplayCommand":
                    try {
                        if (server != null) {
                            ((DisplayCommand) commands.get("display")).setDisplayer(new CLIDisplayer(model.getCurrentLvl(), server.getClientHandler().getOutToClient()));
                            queue.put(commands.get("display"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }

        if (o == server.getClientHandler()) {
            // sending the command recieved by the server to the command parser
            commandParser((String[]) arg);
        }
    }

    @Override
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    try {
                        queue.take().execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        run = false;
    }

    public void commandParser(String[] command) {
        try {
            switch (command[0]) {
                case "load":
                    ((LoadCommand) commands.get("load")).setFilePath(command[1]);
                    ((LoadCommand) commands.get("load")).setModel(model);
                    queue.put(commands.get("load"));
                    break;
                case "save":
                    ((SaveCommand) commands.get("save")).setFilePath(command[1]);
                    ((SaveCommand) commands.get("save")).setLevel(model.getCurrentLvl());
                    queue.put(commands.get("save"));
                    break;
//                case "display":
//                    ((DisplayCommand) commands.get("display")).setDisplayer(new CLIDisplayer(model.getCurrentLvl()));
//                    queue.put(commands.get("display"));
//                    break;
                case "exit":
                    queue.put(commands.get("display"));
                    break;
                case "move":
                    ((MoveCommand) commands.get("move")).setModel(model);
                    ((MoveCommand) commands.get("move")).setDirection(Direction.valueOf(command[1].toUpperCase()));
                    queue.put(commands.get("move"));
                    break;
                default:
                    //TODO: handle unknown commands
                    System.out.println("Unknown command, try again");
                    break;
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}
