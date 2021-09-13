package ru.xodavit.simple.consumer;


import ru.xodavit.http.server.framework.HttpServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ru.xodavit.http.server.app.Main.main(args);
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }).start();

        HttpServer server = null;
        try {
           server = new HttpServer(9998);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.listen();
        System.out.println(server.isStopped());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(server.isStopped());
    }
}
