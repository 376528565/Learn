package com.designPattern.behavior.strategy.demo1;

/**
 * @Author: LQL
 * @Date: 2025/02/27
 * @Description:
 */
public class ServiceContext {

    private AService aService;

    public ServiceContext(String type){
        if ("a1".equals(type))
            aService = new A1ServiceImpl();
        else if ("a2".equals(type))
            aService = new A2ServiceImpl();
        else
            aService = null;
    }

    public void deal(String data){
        if (null != aService) {
            System.out.println("deal ..." + data);
            this.aService.deal(data);
        }else
            System.out.println("类型错误，未执行任何内容...");
    }

}
