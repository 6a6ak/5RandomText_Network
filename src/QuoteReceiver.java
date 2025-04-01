import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class QuoteReceiver {
    public static void main(String[] args) {
        // Create a DatagramSocket to listen on port 5555
        try (DatagramSocket socket = new DatagramSocket(5555)) {
            // Create a buffer to store incoming data
            byte[] buffer = new byte[1024];

            while (true) {
                // Create a DatagramPacket to receive data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // Wait to receive a packet

                // Convert the received data into a string
                String receivedQuote = new String(packet.getData(), 0, packet.getLength());
                // Print the received quote to the console
                System.out.println("Received: " + receivedQuote);
            }
        } catch (Exception e) {
            // Handle any exceptions and print the stack trace
            e.printStackTrace();
        }
    }
}