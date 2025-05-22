package com.io.NIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
/**
 * @Author: LQL
 * @Date: 2024/08/01
 * @Description:
 */
@Component
public class NioDealDetailNote {

    private ServerSocketChannel serverChannel;
    //在 NIO 中，Selector 是关键组件，它允许一个线程管理多个 Channel。
    private Selector selector;

    @Autowired
    private ExecutorService executorService;

    public void start(int port) throws IOException {
        //每个 Channel 代表一个客户端连接
        serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(port));

        selector = Selector.open();
        //将channel注册到selector中
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("NIO File Server started on port " + port);

        //Selector 会不断轮询这些通道的状态，判断它们是否准备好进行 I/O 操作（如读、写、连接等）。
        // 当某个 Channel 有数据需要读取或写入时，Selector 就会通知线程去处理这个通道
        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();

                if (!key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try {
            int bytesRead = clientChannel.read(buffer);
            if (bytesRead == -1) {
                clientChannel.close();
                return;
            }

            buffer.flip();
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);

            // 使用线程池处理文件内容
            executorService.submit(() -> processFileContent(data));

        } catch (IOException e) {
            try {
                clientChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void processFileContent(byte[] data) {

        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        new ByteArrayInputStream(data)))
                ){
            String str;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 这里是文件内容处理的具体逻辑
        System.out.println("Processing file content of size: " + data.length);
    }
}
