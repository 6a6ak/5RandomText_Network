# Quote Sender and Receiver

This project includes two simple Java files demonstrating how to send and receive messages (quotes) over a network using UDP (User Datagram Protocol).

## Files Description

### `QuoteSender.java`

This file sends quotes to a specified receiver.

- **Imports**:
  - Network communication libraries (`DatagramSocket`, `DatagramPacket`, `InetAddress`).
  - Utility libraries (`Arrays`, `List`).

- **Main functionality**:
  1. Defines a list of inspirational quotes.
  2. Creates a socket to send data (`DatagramSocket`).
  3. Targets the local computer (`localhost`) on port `5555`.
  4. Sends each quote from the list every 10 seconds.

### `QuoteReceiver.java`

This file receives and prints quotes sent by the `QuoteSender.java`.

- **Imports**:
  - Network communication libraries (`DatagramSocket`, `DatagramPacket`).

- **Main functionality**:
  1. Creates a socket (`DatagramSocket`) to listen on port `5555`.
  2. Continuously listens for incoming packets (quotes).
  3. Upon receiving a packet, it converts the received data into readable text.
  4. Prints the received quotes to the console.

## How to Run

### Step-by-Step:

1. **Compile** the files:
   ```bash
   javac QuoteSender.java QuoteReceiver.java
   ```

2. **Open two terminal windows**:

   **Terminal 1** (Receiver):
   ```bash
   java QuoteReceiver
   ```

   **Terminal 2** (Sender):
   ```bash
   java QuoteSender
   ```

You will see quotes being sent from the sender and printed in the receiver console every 10 seconds.

## Requirements

- Java Development Kit (JDK) installed on your computer.