package com.web.socket.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: LQL
 * @Date: 2024/07/29
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        BufferedReader consoleReader = null;

        try {
            socket = new Socket("localhost",10010);
            System.out.println("client connect...");
            // 获取输入流和输出流
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // 读取用户输入，并发送到服务器
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                writer.println(userInput);

                // 读取服务器的响应
                String serverResponse = reader.readLine();
                System.out.println("Received from server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (consoleReader != null) consoleReader.close();
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
