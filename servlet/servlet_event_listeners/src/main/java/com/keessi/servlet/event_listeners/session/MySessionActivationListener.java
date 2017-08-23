package com.keessi.servlet.event_listeners.session;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MySessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("MySessionActivationListener.sessionWillPassivate: " + se.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("MySessionActivationListener.sessionDidActivate: " + se.getSession().getId());
    }
}
