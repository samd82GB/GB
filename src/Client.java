import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDR = "localhost";
    private static Socket socket;
    private static final int PORT = 8189;


        public static void main(String[] args) {

            try {
                //подключаемся к серверу по IP и порту
                socket = new Socket(SERVER_ADDR, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner input = new Scanner(socket.getInputStream());
                Scanner clientData = new Scanner(System.in); //создаем сканнер консоли клиента

                //поток входных данных от сервера
                new Thread(() -> {
                    try {
                        while (true) {
                            String str = input.nextLine();//ждём появлени данных от сервера
                            System.out.println("Сервер: " + str); //печатаем их в консоль
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
                //поток данных из консоли клиента
                      try {
                       while (true) {
                           String clientStr = clientData.nextLine(); //считываем строку из консоли
                           out.println(clientStr);//отправляем серверу
                       }
                       } catch (Exception e) {
                           e.printStackTrace();
                      }




            } catch (IOException e) {
                e.printStackTrace();
            }  finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }





    }


