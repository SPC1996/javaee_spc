package com.keessi.servlet.event_listeners.request;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyRequestListener.requestDestroyed: " + sre.getServletContext().getContextPath());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyRequestListener.requestInitialized: " + sre.getServletContext().getContextPath());
    }
}
