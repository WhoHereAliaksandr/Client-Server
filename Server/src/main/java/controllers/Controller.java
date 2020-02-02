package main.java.controllers;

import java.io.*;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.entity.ClientConnection;
import main.java.view.View;

public class Controller {

    private ServerSocket serverSocket;
    private List<ClientConnection> clientSockets;
    private View serverView;


    public Controller(View serverView) {
        this.serverView = serverView;
        clientSockets = new ArrayList<>();
        serverView.getButton().addActionListener(l -> sendMessage());
    }

    public void startServer(int port) {
        try {
            try {
                serverSocket = new ServerSocket(port);
                while (true) {
                    ClientConnection clientConnection = new ClientConnection(serverSocket.accept());
                    clientSockets.add(clientConnection);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                for (ClientConnection client : clientSockets) {
                    client.disconnection();
                }
                serverSocket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void sendMessage() {
        if (serverView.getNewNews().getText().length() == 0) return;
        StringBuilder message = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        message.append(dtf.format(now)).append("\n").append(serverView.getNewNews().getText()).append("\n");
        serverView.getAllNews().append(message.toString());
        serverView.getAllNews().append(System.lineSeparator());
        serverView.getNewNews().setText("");
        Iterator<ClientConnection> clientIterator = clientSockets.iterator();
        while (clientIterator.hasNext()) {
            ClientConnection cc = clientIterator.next();
            if (cc.checkConnection()) {
                cc.send(message.toString());
            } else {
                clientIterator.remove();
            }
        }
    }

}
