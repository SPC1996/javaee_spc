package com.keessi.tiny_spring.beans;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
