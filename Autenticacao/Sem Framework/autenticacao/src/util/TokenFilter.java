package util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class TokenFilter implements HttpHandler {

    private final HttpHandler next;

    public TokenFilter(HttpHandler next) {
        this.next = next;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        TokenValidator validator = new TokenValidator();
        String token = exchange.getRequestHeaders().getFirst("Authorization");
        if(token == null || !validator.validateToken(token)) {
            String response = "{\"error\":\"token invalido\"}";
            exchange.sendResponseHeaders(401, response.getBytes().length);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
            return;
        }
        next.handle(exchange);
    }
}
