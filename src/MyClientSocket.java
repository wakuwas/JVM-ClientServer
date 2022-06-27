import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class MyClientSocket extends Thread {
    @Override
    public void run() {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 2048);
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message = bufferedReader.readLine();
                System.out.println("Считываем записанную информацию : " + message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Клиент закрыт");
        }

}

