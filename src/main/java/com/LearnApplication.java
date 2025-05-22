package com;

import com.collectionContainer.collect.list.ArrayListClass;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author: LQL
 * @Date: 2024/07/23
 * @Description:
 */
@Slf4j
@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class,args);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.springFrameWork");
////        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xx.xml");
//        BeanAlive demo1 = context.getBean(BeanAlive.class);
//        System.out.println(demo1.toString());
//        context.registerShutdownHook();

    }

}
