package com.github.eikefabricio.event;

import com.github.eikefabricio.event.annotation.Route;
import com.github.eikefabricio.event.model.Event;
import com.sun.net.httpserver.HttpExchange;

public class MyEvent extends Event {

    @Route(method = "post")
    public void post(HttpExchange httpExchange) {
        System.out.println("Evento POST foi executado!");
    }

    @Route
    public void get(HttpExchange httpExchange) {
        System.out.println("Evento GET foi executado!");
    }

    @Route(method = "delete")
    public void delete(HttpExchange httpExchange) {
        System.out.println("Evento DELETE foi executado!");
    }

    @Route(method = "put")
    public void put(HttpExchange httpExchange) {
        System.out.println("Evento PUT foi executado!");
    }

}
