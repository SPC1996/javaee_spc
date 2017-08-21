package com.keessi.servlet.async_servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(urlPatterns = "/async_servlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private ExecutorService executor;

    public AsyncServlet() {
        executor = Executors.newFixedThreadPool(10);
    }

    class AsyncService implements Runnable {
        AsyncContext asyncContext;

        public AsyncService(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            try {
                asyncContext.getResponse().getWriter().println("Running inside AsyncService");
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
            asyncContext.complete();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getWriter().println("onComplete");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getWriter().println("onTimeout");
                event.getAsyncContext().complete();
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getWriter().println("onError");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getWriter().println("onStartAsync");
            }
        });
        executor.submit(new AsyncService(asyncContext));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "an async servlet";
    }
}
