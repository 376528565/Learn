//package com.springFrameWork;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: LQL
// * @Date: 2024/07/25
// * @Description:
// */
//@Slf4j
//@Component
//public class MyBeanPostProcessor implements BeanPostProcessor {
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("execute BeanPostProcessor#postProcessBeforeInitialization for {}", beanName);
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info("execute BeanPostProcessor#postProcessAfterInitialization for {}", beanName);
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }
//}
