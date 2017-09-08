package com.keessi.tiny_spring.aop;

public interface ClassFilter {
    boolean matches(Class targetClass);
}
