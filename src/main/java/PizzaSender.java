/**
 * Project: Systems Integration Pizza Shop
 * Purpose Details: Class to send a pizza order request to the server
 * Course: IST 242
 * Author: Aayudh Nandiwdekar
 * Date Developed: [Date]
 * Last Date Changed: [Date]
 * Revision: 1.0
 */

import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PizzaSender {

    public static void sendOrder(String pizzaOrder) throws Exception {
        // The server URL where the order will be sent
        String serverUrl = "http://localhost:8080/sendOrder"; // Ensure this is the correct port
        URL url = new URL(serverUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        // Send the pizza order as a request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = pizzaOrder.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Get the response code to confirm the request was sent successfully
        int responseCode = connection.getResponseCode();
        System.out.println("POST request sent to the server. Response code: " + responseCode);

        // Read and print the server's response
        try (InputStream responseStream = connection.getInputStream()) {
            String response = new String(responseStream.readAllBytes(), "utf-8");
            System.out.println("Server Response: " + response);
        }
    }

    public static void main(String[] args) {
        try {
            // Send an example pizza order to the server
            String pizzaOrder = "1 Large Pepperoni Pizza";
            sendOrder(pizzaOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
