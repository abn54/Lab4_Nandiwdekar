/**
 * Project: Systems Integration Pizza Shop
 * Purpose Details: Class to simulate the pizza order receiver
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

public class PizzaReceiver {

    // The method that receives the pizza order and sends a confirmation message back to the client
    public static void receiveOrder(String pizzaOrder) {
        System.out.println("Pizza order received: " + pizzaOrder);
        // You can add further logic here to process the order
    }
}
