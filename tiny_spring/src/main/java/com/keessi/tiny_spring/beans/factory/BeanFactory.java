package com.keessi.tiny_spring.beans.factory;

public interface BeanFactory {
    Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException;
}
