package com.web.simpleWebServer;



import lombok.Data;

import java.io.*;

/**
 * @Author: LQL
 * @Date: 2024/10/21
 * @Description:
 */
public class SystemResponse {

    private SystemRequest request;

    private OutputStream outputStream;

    // 静态资源的存放路径
    public static final String rootDir = System.getProperty("user.dir") + File.separatorChar + "webroot";

    public SystemResponse(SystemRequest request, OutputStream outputStream) {
        this.request = request;
        this.outputStream = outputStream;
    }

    public SystemRequest getRequest() {
        return request;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * 通过客户端请求的 uri 获取指定静态资源，并拼装成HTTP响应消息，返回给客户端
     */
    public void sendStaticResource() {
        try {
            if (request.getUri().equals("/shutdown")) {
                String msg = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 32\r\n" +
                        "\r\n" +
                        "<h1>server already shutdown</h1>";
                outputStream.write(msg.getBytes());
                return;
            }

            File file = new File(rootDir + request.getUri());
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                String successMsg = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + bytes.length + "\r\n" +
                        "\r\n";
                outputStream.write(successMsg.getBytes());
                outputStream.write(bytes);
                fileInputStream.close();
            } else {
                /**
                 * 这里拼接响应信息，包括：
                 * 1、相应行：HTTP/1.1 404 File Not Found 响应行与请求的 URI 无关，而是描述服务器处理请求的结果状态
                 * 2、响应体：Content-Type: text/html，Content-Length: 23
                 * 响应头包含关于服务器、响应体数据类型、数据长度、编码方式等的信息
                 * 响应头用于告知客户端如何解析和处理响应体中的数据
                 * 3、<h1>File Not Found</h1>
                 * 响应体包含服务器返回的实际数据，即客户端请求的资源。
                 * 响应体内容与请求的具体内容相关，例如请求的是网页 HTML 内容，或 JSON 格式的数据等
                 */
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(errorMessage.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
