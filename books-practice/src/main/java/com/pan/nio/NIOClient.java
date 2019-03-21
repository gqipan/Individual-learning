package com.pan.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Qipan.G
 * @since 2019/3/20 16:00
 */
public class NIOClient {

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try (SocketChannel channel = SocketChannel.open()) {
            channel.connect(inetSocketAddress);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("put message for send server > ");

                // 向服务端发送数据
                String line = scanner.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                byteBuffer.put(line.getBytes(StandardCharsets.UTF_8));
                byteBuffer.flip();
                channel.write(byteBuffer);
                byteBuffer.clear();

                // 接收服务端发来的数据
                int readLength = channel.read(byteBuffer);
                if (readLength == -1) {
                    break;
                }
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                System.out.println("from server: " + new String(bytes, StandardCharsets.UTF_8));
                byteBuffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
