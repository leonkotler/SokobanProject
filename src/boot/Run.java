package boot;

import controller.MyController;
import controller.server.Cli;
import controller.server.MyServer;
import model.MyModel;
import view.MyView;

import java.io.IOException;
import java.util.Observable;

public class Run {

    public static void main(String[] args) throws IOException {
        MyView view = new MyView();
        MyModel model = new MyModel();
        MyController controller = new MyController(model,view);

        view.addObserver(controller);
        model.addObserver(controller);
        controller.start();

        // checking if we need to run in server mode
        if (args.length == 2) {
            if (args[0].equals("-server")) {
                controller.setServer(new MyServer(Integer.parseInt(args[1]), new Cli()));
                ((Cli)(controller.getServer().getClientHandler())).addObserver(controller);
                controller.getServer().start();
            }
        }
    }
}