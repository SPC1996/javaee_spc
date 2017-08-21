package com.keessi.servlet.file_upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/file_upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>File Upload Servlet</title>");
            out.println("</head>");
            out.println("<h1>File Upload Servlet</h1>");
            out.println("Receiving the uploaded file ...<br>");
            out.println("Received " + request.getParts().size() + " parts ...<br>");
            String fileName;
            String line;
            BufferedReader reader;
            for (Part part : request.getParts()) {
                fileName = part.getName();
                reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
                out.println("... writing " + fileName + " part<br><br>");
                while ((line = reader.readLine()) != null) {
                    out.println(line + "<br>");
                }
                out.println("<br>... written<br>");
            }
            out.println("</body>");
            out.println("</html>");
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
}
