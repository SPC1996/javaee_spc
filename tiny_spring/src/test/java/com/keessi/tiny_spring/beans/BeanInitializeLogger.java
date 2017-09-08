package com.keessi.tiny_spring.beans;

import com.keessi.tiny_spring.beans.BeanPostProcessor;

public class BeanInitializeLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Initialize bean " + beanName + " end!");
        return bean;
    }
}
