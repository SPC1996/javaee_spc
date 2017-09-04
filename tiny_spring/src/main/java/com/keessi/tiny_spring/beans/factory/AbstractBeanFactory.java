package com.keessi.tiny_spring.beans.factory;

import com.keessi.tiny_spring.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private final List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + "is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        for (String beanName : beanDefinitionNames) {
            getBean(beanName);
        }
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
