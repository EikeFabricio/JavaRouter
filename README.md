# How to use

Let's create a new route to `/users/`.

```java

// The default route is /
@Router(route = "/users/")
public MyRoutes {
  
  // The default path is /, and the default method is GET
  @Route
  public void get(HttpExchange httpExchange) {
  }

}
```

Start the server in 8080 port...

```java

Server server = new Server(8080);

server.start();
```

When you access the `<server>:8080/users`, it will appear:

`-> [REQUEST] A new GET request was received`
