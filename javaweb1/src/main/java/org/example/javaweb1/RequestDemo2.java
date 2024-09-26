package org.example.javaweb1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }

        String userAgent = req.getHeader("User-Agent");
        if (userAgent.contains("Edg")) {
            System.out.println("Edge");
        } else if (userAgent.contains("Chrome")){
            System.out.println("Chrome");
        }
    }
}
