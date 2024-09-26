package org.example.javaweb1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        System.out.println("username"+username);

        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby"+hobby);
        }

        System.out.println("=========================");
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
        }

        System.out.println("=========================");
        System.out.println("获取所有请求的map名称");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String name : strings) {
            System.out.println(name);
            String[] values = parameterMap.get(name);
            for (String value : values) {
                System.out.println(value);
            }
        }
    }
}
