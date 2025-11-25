package config;

import com.sun.net.httpserver.HttpServer;
import controller.FooBarHandler;
import util.TokenFilter;

import java.net.InetSocketAddress;

public class HttpConfig {

    public void newServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/foo-bar", new TokenFilter(new FooBarHandler()));
        server.setExecutor(null);
        System.out.println("Servidor Iniciado");
        server.start();
    }

}
