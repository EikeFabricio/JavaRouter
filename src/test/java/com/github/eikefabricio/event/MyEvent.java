package com.github.eikefabricio.event;

import com.github.eikefabricio.event.annotation.Router;
import com.github.eikefabricio.event.annotation.type.HttpMethod;
import com.github.eikefabricio.event.model.Event;
import com.sun.net.httpserver.HttpExchange;

public class MyEvent extends Event {

    @Router(method = HttpMethod.POST)
    public void post(HttpExchange httpExchange) {
        System.out.println("Evento POST foi executado!");
    }

    @Router(route = "/seila", method = HttpMethod.GET)
    public void get(HttpExchange httpExchange) {
        System.out.println("Evento GET foi executado!");
    }

    @Router(method = HttpMethod.DELETE)
    public void delete(HttpExchange httpExchange) {
        System.out.println("Evento DELETE foi executado!");
    }

    @Router(method = HttpMethod.PUT)
    public void put(HttpExchange httpExchange) {
        System.out.println("Evento PUT foi executado!");
    }

}
