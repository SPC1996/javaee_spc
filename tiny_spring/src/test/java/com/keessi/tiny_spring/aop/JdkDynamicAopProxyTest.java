package com.keessi.tiny_spring.aop;

import com.keessi.tiny_spring.beans.HelloWorldService;
import com.keessi.tiny_spring.context.ApplicationContext;
import com.keessi.tiny_spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class JdkDynamicAopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        helloWorldServiceProxy.helloWorld();
    }
}
