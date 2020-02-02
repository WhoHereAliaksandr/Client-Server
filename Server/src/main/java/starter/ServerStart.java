package main.java.starter;

import main.java.controllers.Controller;
import main.java.view.View;

public class ServerStart {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.startServer(Integer.parseInt(args[0]));
    }
}
