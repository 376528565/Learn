package com.web.socket.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: LQL
 * @Date: 2024/07/29
 * @Description:
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            // 创建服务端的 ServerSocket，监听端口 8080
            serverSocket = new ServerSocket(10010);
            System.out.println("BIO server started on port 8080...");

            while (true) {
                // 等待客户端连接
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                // 获取输入流和输出流
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                // 读取客户端发送的数据
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received from client: " + line);
                    // 发送响应数据给客户端
                    writer.println("Echo: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
