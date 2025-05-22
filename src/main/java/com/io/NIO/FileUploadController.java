package com.io.NIO;

/**
 * @Author: LQL
 * @Date: 2024/08/01
 * @Description:
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 10010))) {
            ByteBuffer buffer = ByteBuffer.wrap(file.getBytes());
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        }
        return "File uploaded successfully";
    }
}
