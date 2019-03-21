package com.pan.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Qipan.G
 * @since 2019/3/19 20:30
 */
public class NIOServer implements Runnable {

    private Selector selector;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        new Thread(new NIOServer(9999)).start();
    }

    public NIOServer(int port) {
        init(port);
    }

    private void init(int port) {
        try {
            System.out.println("server starting at port:" + port + "...........");
            this.selector = Selector.open();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port));

            serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);

            System.out.println("server started!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 阻塞方法，至少一个通道被选中，此方法才返回
                // 通道是否选择，由注册到多路复用器中的通道标记决定
                this.selector.select();

                Iterator<SelectionKey> keyIterator = this.selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    // 将本次需要处理的通道从集合中移除，当通道准备好时，会再次加入到集合中。下次循环根据新的通道再次执行必要的业务逻辑
                    keyIterator.remove();

                    // 通道是否有效
                    if (key.isValid()) {
                        try {
                            if (key.isAcceptable()) {
                                this.accept(key);
                            }
                            if (key.isConnectable()) {
                                this.connect(key);
                            }
                            if (key.isReadable()) {
                                this.read(key);
                            }
                            if (key.isWritable()) {
                                this.write(key);
                            }
                        } catch (Exception e) {
                            // 出现异常，断开连接
                            key.cancel();
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void write(SelectionKey key) {
        try {
            this.writeBuffer.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            System.out.println( channel.getRemoteAddress() + " write event ..................");
            Scanner scanner = new Scanner(System.in);
            System.out.println("put message for send to client > ");
            String line = scanner.nextLine();
            writeBuffer.put(line.getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(this.selector, SelectionKey.OP_READ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            this.readBuffer.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            System.out.println(channel.getRemoteAddress() + " read event ..................");
            int readLength = channel.read(readBuffer);
            if (readLength == -1) {
                channel.close();
                key.cancel();
                return;
            }
            this.readBuffer.flip();
            byte[] datas = new byte[readBuffer.remaining()];
            readBuffer.get(datas);
            System.out.println("from " + channel.getRemoteAddress() + " client " + new String(datas));
            channel.register(this.selector, SelectionKey.OP_WRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect(SelectionKey key) {
        try {
            SocketChannel channel = (SocketChannel) key.channel();
            System.out.println(channel.getRemoteAddress() + " connect event ..................");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void accept(SelectionKey key) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            // 对等连接
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            System.out.println("from " + channel.getRemoteAddress() + " client  is connection");
            channel.register(this.selector, SelectionKey.OP_READ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
