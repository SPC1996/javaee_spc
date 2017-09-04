package com.keessi.tiny_spring.beans;

public class HelloWorldService {
    private String text;
    private OutputService outputService;

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public void helloWorld() {
        outputService.output(text);
    }
}
