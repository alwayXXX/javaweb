package org.example.javaweb1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println("howTheRequestIsMade "+method);

        String servletPath = req.getServletPath();
        System.out.println("thePathOfTheRequest "+servletPath);

        String queryString = req.getQueryString();
        System.out.println("requestParameters "+queryString);

        String requestURI = req.getRequestURI();
        System.out.println("requestURI "+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL "+requestURL);

        String protocol = req.getProtocol();
        System.out.println("requestAnAgreement "+protocol);

        String contextPath = req.getContextPath();
        System.out.println("requestContextPath "+contextPath);
    }
}
