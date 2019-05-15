package com.dek.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {

    public void init() throws IOException {
        final ServerSocket serverSocket = new ServerSocket(1024);
        try {
            for (;;) {
                final Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from"  + socket);
                // 创建一个新线程处理
                new Thread(() -> {
                    OutputStream out;
                    try {
                        out = socket.getOutputStream();
                        //将消息写给已连接的客户端
                        out.write("Hi!\r\n".getBytes(
                                Charset.forName("UTF-8")));
                        out.flush();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new PlainOioServer().init();
    }

}
