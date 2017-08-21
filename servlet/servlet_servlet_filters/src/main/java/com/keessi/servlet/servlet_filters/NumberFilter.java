package com.keessi.servlet.servlet_filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

@WebFilter(filterName = "NumberFilter", urlPatterns = {"/filtered/*"})
public class NumberFilter implements Filter {
    private static AtomicLong count = new AtomicLong(0);
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse) response);
        doBeforeProcessing(request, wrapper);
        chain.doFilter(request, wrapper);
        doAfterProcessing(request, wrapper);
        out.write(wrapper.toString());
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("before filter number is " + count.getAndIncrement() + "<br/>");
            out.flush();
        }
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("after filter number is " + count.get() + "<br/>");
            out.flush();
        }
    }

    @Override
    public void destroy() {
        //do nothing
    }
}
