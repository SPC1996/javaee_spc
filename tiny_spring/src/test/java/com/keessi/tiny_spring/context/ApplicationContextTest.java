package com.keessi.tiny_spring.context;

import com.keessi.tiny_spring.beans.HelloWorldService;
import org.junit.Test;

public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
