package com.github.eikefabricio;

public class Terminal {

    public static void main(String[] args) {
        try {
            Server server = new Server(8080);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
