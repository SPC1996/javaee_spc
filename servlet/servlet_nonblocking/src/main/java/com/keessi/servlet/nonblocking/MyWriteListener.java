package com.keessi.servlet.nonblocking;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.Queue;

public class MyWriteListener implements WriteListener {
    private ServletOutputStream output = null;
    private Queue<String> queue = null;
    private AsyncContext context = null;

    public MyWriteListener(ServletOutputStream output, Queue queue, AsyncContext context) {
        this.output = output;
        this.queue = queue;
        this.context = context;
    }

    @Override
    public void onWritePossible() throws IOException {
        while (queue.peek() != null && output.isReady()) {
            String data = queue.poll();
            output.print(data);
        }
        if (queue.peek() == null) {
            context.complete();
        }
    }

    @Override
    public void onError(Throwable t) {
        context.complete();
        t.printStackTrace();
    }
}
