package com.keessi.servlet.event_listeners;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/event_listeners")
public class MyServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet : Event Listeners</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet : Event Listeners</h1>");
        out.println("<h2>Setting, updating, and removing ServletContext Attributes</h2>");
        request.getServletContext().setAttribute("attribute1", "attribute-value1");
        request.getServletContext().setAttribute("attribute1", "attribute-update-value1");
        request.getServletContext().removeAttribute("attribute1");
        out.println("done");
        out.println("<h2>Setting, updating, and removing HttpSession Attributes</h2>");
        request.getSession(true).setAttribute("attribute1", "attribute-value1");
        request.getSession().setAttribute("attribute1", "attribute-updated-value1");
        request.getSession().removeAttribute("attribute1");
        out.println("done");
        out.println("<h2>Setting, updating, and removing ServletRequest Attributes</h2>");
        request.setAttribute("attribute1", "attribute-value1");
        request.setAttribute("attribute1", "attribute-updated-value1");
        request.removeAttribute("attribute1");
        out.println("done");
        out.println("<h2>Invalidating session</h2>");
        request.getSession().invalidate();
        out.println("done");
        out.println("<br><br>Check output in server log");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
