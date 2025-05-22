package com.designPattern.structure.facade.demo1;

import lombok.AllArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2024/11/28
 * @Description:
 */
@AllArgsConstructor
public class DealFacade {

    private Facade fService;

    public void deal(){
        fService.deal2();
        fService.deal1();
    }

}
