package com.web.simpleWebServer;

import java.io.IOException;

/**
 * @Author: LQL
 * @Date: 2025/01/11
 * @Description: servlet接口,支持处理请求和生成响应。每个具体的功能由不同的 Servlet 实现类来完成
 */
public interface Servlet {

    void service(SystemRequest request,SystemResponse response) throws IOException;

}
