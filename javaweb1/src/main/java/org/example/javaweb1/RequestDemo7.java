package org.example.javaweb1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, IOException {
        System.out.println(request.getAttribute("msg"));

        ServletContext context = request.getServletContext();
        String info = String.valueOf(context.getAttribute("info"));
        System.out.println(info);
    }
}
