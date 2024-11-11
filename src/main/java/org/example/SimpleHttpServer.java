/**
 * Project: Systems Integration Pizza Shop
 * Purpose Details: A simple HTTP server that listens for pizza orders.
 * Course: IST 242
 * Author: Aayudh Nandiwdekar
 * Date Developed: [Date]
 * Last Date Changed: [Date]
 * Revision: 1.0
 */

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws Exception {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/sendOrder", new PizzaReceiverHandler());
        server.setExecutor(null); // Creates a default executor
        server.start();
        System.out.println("Server is listening on port 8080...");
    }

    static class PizzaReceiverHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();
            if ("POST".equals(requestMethod)) {
                // Get the request body (pizza order)
                String pizzaOrder = new String(exchange.getRequestBody().readAllBytes(), "UTF-8");
                System.out.println("Received order: " + pizzaOrder);

                // Send a response back to the client
                String response = "Order received: " + pizzaOrder;
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
