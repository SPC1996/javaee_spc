package com.keessi.tiny_spring.beans;

import com.keessi.tiny_spring.beans.factory.AutowireCapableBeanFactory;
import com.keessi.tiny_spring.beans.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void test() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.keessi.tiny_spring.beans.HelloWorldService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
