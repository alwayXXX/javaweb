package org.example.javaweb1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
