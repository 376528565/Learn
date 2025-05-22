package com.springFrameWork;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: LQL
 * @Date: 2024/07/23
 * @Description:
 */
@Component
@Data
public class Demo1{

    public void show(){
        System.out.println(" som deal");
    }

}
