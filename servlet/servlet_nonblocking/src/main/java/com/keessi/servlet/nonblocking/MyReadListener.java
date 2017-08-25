package com.keessi.servlet.nonblocking;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyReadListener implements ReadListener {
    private ServletInputStream input = null;
    private Queue<String> queue = new LinkedBlockingQueue<>();
    private AsyncContext context = null;
    private HttpServletResponse response = null;

    public MyReadListener(ServletInputStream input, HttpServletResponse response, AsyncContext context) {
        this.input = input;
        this.response = response;
        this.context = context;
    }

    @Override
    public void onDataAvailable() throws IOException {
        System.out.println("Data is available");
        StringBuilder sb = new StringBuilder();
        int len;
        byte[] bytes = new byte[1024];
        while (input.isReady() && (len = input.read(bytes)) != -1) {
            String data = new String(bytes, 0, len, "UTF-8");
            sb.append(data);
        }
        queue.add(sb.toString());
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("Data is all read");
        ServletOutputStream output = response.getOutputStream();
        WriteListener writeListener = new MyWriteListener(output, queue, context);
        output.setWriteListener(writeListener);
    }

    @Override
    public void onError(Throwable t) {
        context.complete();
        t.printStackTrace();
    }
}
