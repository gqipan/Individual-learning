package com.pan.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Qipan.G
 * @date 2018/11/16 23:07
 * @since 1.0.0
 */
public class ServerSocketTest {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            try (Socket incoming = serverSocket.accept()) {
                InputStream inputStream = incoming.getInputStream();
                try (Scanner scanner = new Scanner(inputStream)) {

                    OutputStream outputStream = incoming.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.printf("Hello! Enter BYE to exit!");

                    boolean done = false;
                    while (!done && scanner.hasNext()) {
                        String line = scanner.nextLine();
                        System.out.println(String.format("Echo:%s", line));
                        if ("BYE".equals(line.trim())) {
                            done = true;
                        }
                    }
                    out.printf(String.format("我是%s, %s我很累", "龚启盼", "25岁"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
