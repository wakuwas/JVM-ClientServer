import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MYclassServerSocket {
    public static void main(String[] args) {
        System.out.println("Запускаем сервер");
        MyClientSocket clientSocket = new MyClientSocket();
        clientSocket.start();
        try (ServerSocket myServerSocket = new ServerSocket(2048);

             Socket socket = myServerSocket.accept();

             PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))){

            printWriter.println("Информация сервера");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Сервер закрыт");

    }

}
