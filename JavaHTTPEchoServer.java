import java.io.*;
import java.net.*;
import java.util.*;

public class JavaHTTPEchoServer {
        public static void main(String[] args)
        {
            try
            {
                // Устанавливаем сервер сокет
                ServerSocket s = new ServerSocket(8080);
                while(true) {
                    System.out.println("Wait for TCP-connection");
                    // Ждём подключения
                    Socket incoming = s.accept();
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
                    }
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }
}
