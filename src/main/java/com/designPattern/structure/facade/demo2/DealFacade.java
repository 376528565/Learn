package com.designPattern.structure.facade.demo2;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class DealFacade {

    private Facade facade;

    public DealFacade(){
        this.facade = null;
    };

    public DealFacade(Facade facade){
        this.facade = facade;
    }

    public void deal(){
        this.facade.deal2();
        this.facade.deal1();
    }

    public static void main(String[] args) {
        DealFacade dealFacade = new DealFacade(new FacadeImpl());
        dealFacade.deal();
    }

}
