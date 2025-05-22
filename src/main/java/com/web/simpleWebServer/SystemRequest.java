package com.web.simpleWebServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author: LQL
 * @Date: 2024/10/21
 * @Description:
 */
public class SystemRequest {

    private String uri;

    /**
     * 从请求输入流中解析http协议内容，获取请求信息
     * @param inputStream
     */
    public void parse(InputStream inputStream){
        try {
            byte[] bytes = new byte[1024];
            int readLength = inputStream.read(bytes);
            StringBuilder content = new StringBuilder();
            while (readLength != -1){
                //通过 Socket 输入流读取时，你获得的是经过 UTF-8 编码的字节序列。
                // 当将这些字节转成字符串时，通常会使用 UTF-8 编码来解码字节数组，从而得到正确的中文字符
                content.append(new String(bytes, StandardCharsets.UTF_8));
                if (readLength < 1024)
                    break;
                readLength = inputStream.read(bytes);
            }
            System.out.println("request body --->");
            String requestLine = content.toString().split("\r\n")[0]; // HTTP 请求的首行
            String uri = requestLine.split(" ")[1]; // 获取 URI 部分
            System.out.println("Original URI: " + uri);
            String[] uriParts = uri.split("\\?");
            if (uriParts.length > 1) {
                String queryString = uriParts[1];
                String[] params = queryString.split("&");
                for (String param : params) {
                    String[] keyValue = param.split("=");
                    if (keyValue.length == 2) {
                        String key = keyValue[0];
                        String value = URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8.name()); // URL 解码
                        System.out.println("Parameter: " + key + " = " + value);
                    }
                }
            }
            System.out.println(content.toString());
            setUri(content.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUri(){
        return this.uri;
    }

    public void setUri(String uri){
        int index1 = uri.indexOf(" ");
        if(index1 == -1) {
            return;
        }
        int index2 = uri.indexOf(" ", index1+1);
        String substring = uri.substring(index1+1, index2);
        this.uri = substring;
    }

}
