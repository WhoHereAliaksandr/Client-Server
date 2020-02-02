package controllers;

import view.View;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;

public class Controller {
    private View clientView;
    private Socket socket;
    private BufferedReader br;

    public Controller(View clientView) {
        this.clientView = clientView;
        this.clientView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (socket != null) disconnected();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void connectToServer(String ip, int port) {
        try {
            try {
                socket = new Socket(ip, port);
                getMessageFromServer();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                socket.close();
                socket = null;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void getMessageFromServer() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            while (socket.isConnected()) {
                String line;
                while ((line = br.readLine()) != null) {
                    clientView.getAllNews().append(line);
                    clientView.getAllNews().append(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            clientView.getAllNews().append(System.lineSeparator());
            clientView.getAllNews().append(e.getMessage());
        }
    }

    public void disconnected() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject("disconnect");
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
