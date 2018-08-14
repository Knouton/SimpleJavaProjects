import java.io.*;
import java.net.*;
import java.util.*;

public class JavaHTTPEchoServer {
        public static void main(String[] args) {
        try
        {
            // Устанавливаем сервер сокет
            ServerSocket socket = new ServerSocket(8080);
            while(true) {
                System.out.println("Wait for TCP-connection");
                // Ждём подключения
                Socket incoming = socket.accept();
                System.out.println("Get some connection");
                try(InputStream inStream = incoming.getInputStream();
                    OutputStream outStream = incoming.getOutputStream();
                )
                {
                    Scanner in = new Scanner(inStream);
                    PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

                    out.println("Hello! Enter BYE to exit.");

                    // Эхо ответ
                    boolean done = false;
                    while (!done && in.hasNextLine())
                    {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
                finally
                {
                    incoming.close();
                    socket.close();
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
