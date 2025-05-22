package com.springFrameWork;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author: LQL
 * @Date: 2024/07/25
 * @Description:
 */
@Slf4j
@ToString
@Component
public class BeanAlive implements BeanFactoryAware, BeanNameAware, ApplicationContextAware
    , InitializingBean, DisposableBean {

    private String key;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    private String beanName;

    @Resource
    Alen alen;

    /**
     * 通过@PostConstruct 可以实现在bean生命周期创建实例对象后对bean进行操作
     */
    @PostConstruct
    public void init(){
        alen.show();
        this.key = "alen";
    }


    public BeanAlive(){
        log.info("executor class new BeanAlive");
    }
    public void setKey(String key){
        log.info("executor set key ({})",key);
        this.key = key;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("deal BeanFactoryAware#setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        log.info("deal BeanNameAware#setBeanFactory");
        this.beanName = beanName;
    }

    @Override
    public void destroy() throws Exception {
        log.info("execute DisposableBean#destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("execute InitializingBean#afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("execute ApplicationContextAware#setApplicationContext");
        this.applicationContext = applicationContext;
    }

    public void doInit() {
        log.info("execute User#doInit");
    }

    public void doDestroy() {
        log.info("execute User#doDestroy");
    }
}
