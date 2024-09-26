package org.example.javaweb1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, IOException {
        System.out.println("RequestDemo6 requested");
        response.getWriter().write("RequestDemo6 requested");
        request.setAttribute("msg", "hello");

        ServletContext context = request.getServletContext();
        context.setAttribute("info", "hello");
    }
}
