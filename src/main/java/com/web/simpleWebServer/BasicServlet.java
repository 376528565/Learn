package com.web.simpleWebServer;

import java.io.IOException;

/**
 * @Author: LQL
 * @Date: 2025/01/11
 * @Description: 简单servlet动态返回信息实现
 */
public class BasicServlet implements Servlet{
    @Override
    public void service(SystemRequest request, SystemResponse response) throws IOException {
        String content = "<h1>Hello, this is a dynamic response!</h1>";
        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + content.getBytes().length + "\r\n" +
                "\r\n" +
                content;
        response.getOutputStream().write(httpResponse.getBytes());
    }
}
