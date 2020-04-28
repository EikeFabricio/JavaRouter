package com.github.eikefabricio.event.handler;

import com.github.eikefabricio.event.controller.EventController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class WebHandler implements HttpHandler {

    public void handle(HttpExchange httpExchange) {
        try {
            EventController.call(httpExchange);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
