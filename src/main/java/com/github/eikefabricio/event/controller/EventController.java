package com.github.eikefabricio.event.controller;

import com.github.eikefabricio.event.annotation.Route;
import com.github.eikefabricio.event.model.Event;
import com.sun.net.httpserver.HttpExchange;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventController {

    private static final List<com.github.eikefabricio.event.Route> routes = new ArrayList<>();

    public static void load() {
        Reflections reflections = new Reflections("com.github.eikefabricio");

        Set<Class<? extends Event>> classes = reflections.getSubTypesOf(Event.class);

        for (Class clazz : classes) {
            for (Method method : clazz.getMethods()) {
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation.annotationType() == Route.class) {
                        Route eventHandler = (Route) annotation;

                        routes.add(new com.github.eikefabricio.event.Route(eventHandler.route(),
                                eventHandler.method(), clazz, method));
                    }
                }
            }
        }

    }

    public static void call(HttpExchange httpExchange) {
        for (com.github.eikefabricio.event.Route route : routes) {
            if (!httpExchange.getRequestMethod().equalsIgnoreCase(route.getHttpMethod())) return;
            if (!httpExchange.getRequestURI().getPath().equalsIgnoreCase(route.getRoute())) return;

            try {
                route.getMethod().invoke(route.getClazz().newInstance(), httpExchange);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
