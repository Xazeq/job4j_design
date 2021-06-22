package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())
                     )) {
                    String answer = in.readLine();
                    while (!answer.isEmpty()) {
                        if (answer.contains(" /?msg=")) {
                            String message = answer.split(" ")[1].split("=")[1];
                            if (message.equals("Exit")) {
                                answer = "Exit";
                                break;
                            } else if (message.equals("Hello")) {
                                answer = message;
                                break;
                            } else {
                                answer = "What";
                                break;
                            }
                        }
                        answer = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    if (answer.equals("Exit")) {
                        server.close();
                    }
                } catch (IOException e) {
                    LOG.error("Exception in inner try", e);
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in outer try", e);
        }
    }
}
