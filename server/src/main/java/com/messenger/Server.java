package com.messenger;

import com.google.inject.Guice;
import com.messenger.config.ServerConfig;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] ar) {
        Server server = Guice.createInjector().getInstance(Server.class);
        server.run();
    }

    private void run() {
        try (ServerSocket ss = new ServerSocket( ServerConfig.getPort())) {
            ss.setReuseAddress(true);
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = ss.accept();
                new Thread(new RequestHandler( socket )).start();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
