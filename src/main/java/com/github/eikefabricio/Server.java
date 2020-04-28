package com.github.eikefabricio;

import com.github.eikefabricio.event.controller.EventController;
import com.github.eikefabricio.event.handler.WebHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class Server {

    private HttpServer httpServer;

    public Server(int port) {
        try {
            this.httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-> [STARTING] Servidor iniciando na porta " + port + "!");
    }

    public HttpServer getHttpServer() {
        return httpServer;
    }

    public void setHttpServer(HttpServer httpServer) {
        this.httpServer = httpServer;
    }

    private Server context(String uri, HttpHandler handler) {
        getHttpServer().createContext(uri, handler);
        return this;
    }

    public void start() {
        getHttpServer().setExecutor(null);
        context("/", new WebHandler());
        EventController.load();
        System.out.println("-> [START] Servidor iniciado!");
        getHttpServer().start();
    }
}
