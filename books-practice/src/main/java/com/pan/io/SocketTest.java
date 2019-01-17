package com.pan.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Qipan.G
 * @date 2018/11/16 22:46
 * @since 1.0.0
 */
public class SocketTest {

    public static void main(String[] args) {
//        try(Socket socket = new Socket("www.baidu.com", 22)){
//            InputStream inputStream = socket.getInputStream();
//            Scanner scanner = new Scanner(inputStream);
//            while (scanner.hasNext()){
//                String nextLine = scanner.nextLine();
//                System.out.println(nextLine);
//            }
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Socket 如果不设置连接超时，有可能会一直阻塞，直到建立连接为止
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 8189), 2000);
//         设置读的超时时间
            socket.setSoTimeout(1000);
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()){
                String nextLine = scanner.nextLine();
                System.out.println(nextLine);
            }
//            socket.isConnected();
//            socket.isClosed();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            InetAddress address = InetAddress.getByName("www.google.com");
//            byte[] addressByte = address.getAddress();
//            System.out.println(Arrays.toString(addressByte));
//
//            System.out.println(address.getHostAddress());
//            System.out.println(address.getHostName());
//
//
//            InetAddress[] allByName = InetAddress.getAllByName("www.google.com");
//            for (InetAddress inetAddress : allByName) {
//                System.out.println(inetAddress);
//            }
//            System.out.println(InetAddress.getLocalHost());
//            System.out.println(InetAddress.getLoopbackAddress());
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }

}
