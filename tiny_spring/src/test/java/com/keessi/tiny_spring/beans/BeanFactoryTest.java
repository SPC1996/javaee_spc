package com.keessi.tiny_spring.beans;

import com.keessi.tiny_spring.beans.factory.AutowireCapableBeanFactory;
import com.keessi.tiny_spring.beans.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void test() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.keessi.tiny_spring.beans.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
