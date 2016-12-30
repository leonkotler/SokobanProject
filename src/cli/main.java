package cli;

import java.io.IOException;

public class main {

    public static void main(String[] args) {
        Cli cli = new Cli();
        try {
            cli.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
