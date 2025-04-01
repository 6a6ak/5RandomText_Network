import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

public class QuoteSender {
    public static void main(String[] args) {
        // List of quotes to send
        List<String> quotes = Arrays.asList(
            "The only limit to our realization of tomorrow is our doubts of today.",
            "In the middle of every difficulty lies opportunity.",
            "Life is 10% what happens to us and 90% how we react to it.",
            "Do not wait to strike till the iron is hot; but make it hot by striking.",
            "The best way to predict the future is to create it."
        );

        try (DatagramSocket socket = new DatagramSocket()) { // Create a DatagramSocket
            InetAddress address = InetAddress.getByName("localhost"); // Set the target address
            int port = 5555; // Set the target port

            while (true) {
                // Loop through the list of quotes
                for (String quote : quotes) {
                    // Convert the quote to bytes
                    byte[] buffer = quote.getBytes();
                    // Create a DatagramPacket to send the quote
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                    socket.send(packet); // Send the packet
                    System.out.println("Sent: " + quote); // Print the sent quote
                    Thread.sleep(10000); // Sleep for 10 seconds before sending the next quote
                }
            }
        } catch (Exception e) {
            // Handle any exceptions and print the stack trace
            e.printStackTrace();
        }
    }
}