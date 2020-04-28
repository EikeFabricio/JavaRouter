package com.github.eikefabricio.event.controller;

import com.github.eikefabricio.event.Route;
import com.github.eikefabricio.event.annotation.Router;
import com.github.eikefabricio.event.model.Event;
import com.sun.net.httpserver.HttpExchange;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventController {

    private static final List<Route> routes = new ArrayList<>();

    public static void load() {
        Reflections reflections = new Reflections("com.github.eikefabricio");

        Set<Class<? extends Event>> clazz = reflections.getSubTypesOf(Event.class);

        for (Class c : clazz) {
            for (Method method : c.getMethods()) {
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation.annotationType() == Router.class) {
                        Router eventHandler = (Router) annotation;

                        routes.add(new Route(eventHandler.route(), eventHandler.method(), c, method));
                    }
                }
            }
        }
    }

    public static void call(HttpExchange httpExchange) {
        routes.stream().filter(it -> it.getHttpMethod().toString().equals(httpExchange.getRequestMethod()))
                .filter(it -> it.getRoute()
                        .equals(httpExchange.getRequestURI().getPath())).forEach(it -> {
            try {
                it.getMethod().invoke(it.getClazz().newInstance(), httpExchange);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
