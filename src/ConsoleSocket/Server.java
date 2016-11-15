package ConsoleSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhouliang on 2016/11/15.
 */
public class Server {
    int port;
    Socket client;
    ServerSocket serverSocket;
    public static void main(String[] args){
        new Server();
    }
    public Server(){
        port= 8888;
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                client = serverSocket.accept();
                Mythread mythread = new Mythread();
                mythread.start();
                BufferedReader br = null;
                br = new BufferedReader(new InputStreamReader(client
                        .getInputStream()));
                String msg1;
                while ((msg1 = br.readLine()) != null) {
                    msg1 = "客户端说："+msg1;
                    System.out.println(msg1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class Mythread extends Thread{
        public void run(){
            try {
                BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                String msg2;
                while (true) {
                    msg2 = re.readLine();
                    pw.println(msg2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

