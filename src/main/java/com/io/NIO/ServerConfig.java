package com.io.NIO;

/**
 * @Author: LQL
 * @Date: 2024/08/01
 * @Description:
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ServerConfig {

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Bean
    public NioDealDetailNote nioFileServer(ExecutorService executorService) {
        NioDealDetailNote server = new NioDealDetailNote();
        new Thread(() -> {
            try {
                server.start(10010);  // 启动服务器在10010端口
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        return server;
    }
}
