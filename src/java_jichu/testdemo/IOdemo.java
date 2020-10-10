package java_jichu.testdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class IOdemo {

    public static void NIODemo() {
        int port = 6666;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Selector selector = Selector.open();
                     ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
                    serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                    serverSocketChannel.configureBlocking(false);
                    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                    while (true) {
                        selector.select(); // 阻塞等待就绪的 Channel
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            try (SocketChannel channel = ((ServerSocketChannel) key.channel()).accept()) {
                                channel.write(Charset.defaultCharset().encode("老王，你好~"));
                            }
                            iterator.remove();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Socket 客户端 1（接收信息并打印）
                try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                    bufferedReader.lines().forEach(s ->
                            System.out.println("客户端 1 打印：" + s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Socket 客户端 2（接收信息并打印）
                try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                    bufferedReader.lines().forEach(s ->
                            System.out.println("客户端 2 打印：" + s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //基于事件和回调机制
    /*public void AIODemo() throws InterruptedException {
        int port = 8888;
        new Thread(new Runnable() {
            @Override
            public void run() {
                AsynchronousChannelGroup group = null;
                try {
                    group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
                    AsynchronousServerSocketChannel server =
                            AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                    server.accept(null,
                            new CompletionHandler<AsynchronousSocketChannel,
                                    AsynchronousServerSocketChannel>() {
                                @Override
                                public void
                                completed(AsynchronousSocketChannel result,  AsynchronousServerSocketChannel attachment) {
                                    server.accept(null, this); // 接收下一个 请求
                                    try {
                                        Future<Integer> f = result.write(Charset.defaultCharset().encode("Hi, 老王"));
                                        f.get();
                                        System.out.println("服务端发送时间：" + DateFormat.getDateTimeInstance().format(new Date()));
                                        result.close();
                                    } catch (InterruptedException |
                                            ExecutionException | IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
                                }
                            });
                    group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Socket 客户端
        AsynchronousSocketChannel client = null;
        try {
            client = AsynchronousSocketChannel.open();
            Future<Void> future = client.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
            future.get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ByteBuffer buffer = ByteBuffer.allocate(100);
        AsynchronousSocketChannel finalClient = client;
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("客户端打印：" + new
                        String(buffer.array()));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                try {
                    finalClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(10 * 1000);
    }*/

    public static void main(String[] args) {
        NIODemo();
    }
}
