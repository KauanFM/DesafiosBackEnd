package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class FooBarHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(204, -1);
    }
}
