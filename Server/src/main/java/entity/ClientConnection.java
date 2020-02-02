package main.java.entity;

import java.io.*;
import java.net.Socket;

public class ClientConnection {

    private Socket socket;
    private OutputStreamWriter clientSocketWriter;
    private InputStreamReader clientSocketReader;

    public ClientConnection(Socket socket) throws IOException {
        this.socket = socket;
        clientSocketWriter = (new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
        clientSocketReader = (new InputStreamReader(socket.getInputStream(), "UTF8"));
    }

    public void send(String message) {
        try {
            clientSocketWriter.append(message);
            clientSocketWriter.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Socket getSoket() {
        return socket;
    }

    public boolean checkConnection() {
        try {
            return !clientSocketReader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void disconnection() {
        try {
            clientSocketWriter.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}