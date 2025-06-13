package com.springFrameWork;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LQL
 * @Date: 2025/05/29
 * @Description:
 */
public class XmlBeanFactory {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[] {"alen.xml","applicationContext.xml"});
        Alen alen = (Alen)applicationContext.getBean("alen");
        Bella bella = (Bella)applicationContext.getBean("bella");
        alen.show();
        System.out.println("bella name: " + bella.name);
        bella.deal();
    }

}
