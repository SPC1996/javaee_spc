package com.keessi.tiny_spring.aop;

import com.keessi.tiny_spring.beans.HelloWorldService;
import com.keessi.tiny_spring.beans.HelloWorldServiceImp;
import org.junit.Assert;
import org.junit.Test;

public class AspectJExpressionPointcutTest {
    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.keessi.tiny_spring.beans.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.keessi.tiny_spring.beans.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImp.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImp.class);
        Assert.assertTrue(matches);
    }
}
