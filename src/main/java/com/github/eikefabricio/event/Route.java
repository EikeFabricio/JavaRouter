package com.github.eikefabricio.event;

import java.lang.reflect.Method;

public class Route {

    private final String route;
    private final String httpMethod;
    private final Class<?> clazz;
    private final Method method;

    public Route(String route, String httpMethod, Class<?> clazz, Method method) {
        this.route = route;
        this.httpMethod = httpMethod;
        this.clazz = clazz;
        this.method = method;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRoute() {
        return route;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Method getMethod() {
        return method;
    }

}
