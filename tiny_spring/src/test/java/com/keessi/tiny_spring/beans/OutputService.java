package com.keessi.tiny_spring.beans;


public class OutputService {
    private HelloWorldService helloWorldService;

    public void output(String text) {
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
