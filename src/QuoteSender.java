import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

public class QuoteSender {
    public static void main(String[] args) {
        List<String> quotes = Arrays.asList(
            "The only limit to our realization of tomorrow is our doubts of today.",
            "In the middle of every difficulty lies opportunity.",
            "Life is 10% what happens to us and 90% how we react to it.",
            "Do not wait to strike till the iron is hot; but make it hot by striking.",
            "The best way to predict the future is to create it."
        );

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 5555;

            while (true) {
                for (String quote : quotes) {
                    byte[] buffer = quote.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                    socket.send(packet);
                    System.out.println("Sent: " + quote);
                    Thread.sleep(10000); // Sova i 10 sekunder
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}