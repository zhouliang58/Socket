package ConsoleSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by zhouliang on 2016/11/15.
 */
public class Client {
    public int port = 8888;
    Socket socket = null;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            socket = new Socket("127.0.0.1", port);
            new Cthread().start();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            String msg1;
            while ((msg1 = br.readLine()) != null) {
                msg1 = "服务器说："+msg1;
                System.out.println(msg1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Cthread extends Thread {
        public void run() {
            try {
                BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                String msg2;
                while (true) {
                    msg2 = re.readLine();
                    pw.println(msg2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
