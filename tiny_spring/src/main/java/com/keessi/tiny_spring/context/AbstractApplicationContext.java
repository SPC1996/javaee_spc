package com.keessi.tiny_spring.context;

import com.keessi.tiny_spring.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        return beanFactory.getBean(name);
    }
}
