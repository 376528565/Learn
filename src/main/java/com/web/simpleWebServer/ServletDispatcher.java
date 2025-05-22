package com.web.simpleWebServer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LQL
 * @Date: 2025/01/11
 * @Description: 类似springboot中的dispatcherServlet，
 * 根据具体的请求路径映射到具体的API，执行响应的处理逻辑并封装返回结果
 */
public class ServletDispatcher {

    private Map<String,Servlet> servletMapping = new HashMap<>();

    public ServletDispatcher() {
        // 注册 URI 到 Servlet 的映射关系
        servletMapping.put("/hello", new BasicServlet());
    }

    public Servlet getServlet(String uri){
        return servletMapping.get(uri);
    }

}
