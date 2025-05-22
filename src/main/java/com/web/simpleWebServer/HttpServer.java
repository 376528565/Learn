package com.web.simpleWebServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: LQL
 * @Date: 2024/10/22
 * @Description:
 */
public class HttpServer {

    // 声明一个结束标识，用来判断是否需要终止服务
    public static boolean shutDown = false;


    /**
     * 本例子简单实现了基于socket和servlet实现客户端http请求处理，模拟了基础web容器实现逻辑
     * @param args
     */

    public static void main(String[] args) {
        try {
            //监听服务器的特定端口，backlog定义传入连接的最大队列长度
            ServerSocket serverSocket = new ServerSocket(8080,10, InetAddress.getByName("0.0.0.0"));
            ServletDispatcher servletDispatcher = new ServletDispatcher();//初始化servlet调度器
            Socket socket;
            while(!shutDown) {
                socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                SystemRequest request = new SystemRequest();
                request.parse(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                SystemResponse response = new SystemResponse(request,outputStream);
                //判断是否是动态请求,静态请求还是执行原始处理逻辑
                Servlet servlet = servletDispatcher.getServlet(request.getUri());
                if (null != servlet)
                    servlet.service(request,response); //调用动态请求
                else
                    response.sendStaticResource(); //处理静态资源
                inputStream.close();
                socket.close();

                // 判断是否是结束服务的请求
                shutDown = request.getUri().equals("/shutdown");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
