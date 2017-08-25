package com.keessi.servlet.nonblocking;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/client"}, asyncSupported = true)
public class Client extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext context = req.startAsync();
        context.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getOutputStream().print("Complete");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("My asyncListener.onTimeout");
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                event.getThrowable().printStackTrace();
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
            }
        });
        ServletInputStream input = req.getInputStream();
        ReadListener readListener = new MyReadListener(input, resp, context);
        input.setReadListener(readListener);
    }

    @Override
    public String getServletInfo() {
        return "client_servlet";
    }
}
