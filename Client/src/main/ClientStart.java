package main;

import controllers.Controller;
import view.View;

public class ClientStart {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.connectToServer(args[0], Integer.parseInt(args[1]));
    }
}