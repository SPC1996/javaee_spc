package com.keessi.servlet.event_listeners.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

@WebListener
public class MySessionIdListener implements HttpSessionIdListener {
    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        System.out.println("MySessionIdListener.sessionIdChanged: new" + event.getSession().getId() + ", old=" + oldSessionId);
    }
}
