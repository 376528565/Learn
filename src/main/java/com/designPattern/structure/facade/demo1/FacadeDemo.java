package com.designPattern.structure.facade.demo1;


/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
public class FacadeDemo {

    public static void main(String[] args) {
        DealFacade dealFacade = new DealFacade(new FacadeServiceImpl());
        dealFacade.deal();
    }

}
