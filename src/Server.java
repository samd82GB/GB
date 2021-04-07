import javax.crypto.spec.PSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запустился");

            socket = server.accept();
            System.out.println("Клиент подключен");
            Scanner input = new Scanner(socket.getInputStream()); //считываем данные из входного потока от клиента
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //печать в исходящий поток данных


            //поток входных данных от клиента
            new Thread(() -> {
                try {
                    while (true) {
                        String str = input.nextLine(); //запись данных в переменную для печати в консоль
                        System.out.println("Клиент: " + str);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();


            Scanner serverData = new Scanner(System.in); //сканнер считывания данных из консоли сервера
            try {
                while (true) {
                    String outputStr = serverData.nextLine(); //запись данных консоли сервера в переменную
                    out.println(outputStr); //печать в исходящий поток данных из консоли сервера
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }}




