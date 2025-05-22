package com.designPattern.structure.decorator.demo2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2025/02/14
 * @Description:
 */
public class DecoratorNotify implements Notify{

    private Notify notify;

    public DecoratorNotify(Notify notify){
        this.notify = notify;
    }

    @Override
    public void sendNotify() {
        notify.sendNotify();
    }
}
