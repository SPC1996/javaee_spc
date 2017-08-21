package com.keessi.servlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test_servlet")
@MultipartConfig(location = "/tmp")
public class TestServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            Cookie[] cookies = request.getCookies();
            out.println("Found cookie: <br>");
            for (Cookie cookie : cookies) {
                out.println(cookie.getName() + " " + cookie.getValue() + " " + cookie.getMaxAge() + "<br>");
            }
            out.println("<br>");

            Cookie cookie = new Cookie("cookie_key", "cookie_value");
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            out.println("<br><br>Set a new cookie");

            cookie = new Cookie("http_only_key", "http_only_value");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            out.println("<br>Set a new httpOnly cookie<br><br>");
            out.println("Check what cookies are visible by");
            out.println("<a href=\"http://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/index_cookies.jsp\">clicking here</a>"
            );
            out.println("</body>");
            out.println("<html>");
        }
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
        return "Servlet cookies";
    }
}
