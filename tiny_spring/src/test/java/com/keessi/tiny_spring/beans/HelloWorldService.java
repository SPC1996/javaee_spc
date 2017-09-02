package com.keessi.tiny_spring.beans;

public class HelloWorldService {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void helloWorld() {
        System.out.println(text);
    }
}
