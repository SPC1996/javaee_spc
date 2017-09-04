package com.keessi.tiny_spring.beans.factory;

import com.keessi.tiny_spring.beans.BeanDefinition;

public interface BeanFactory {
    Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, NoSuchFieldException, InstantiationException;
}
