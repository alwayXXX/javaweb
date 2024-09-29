package org.example.bookonline.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bookonline.entity.User;
import org.example.bookonline.service.UserService;
import org.example.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException{
        userService = new UserServiceImpl();
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userService.signIn(account,password);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/index");
        }else {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<script>alert('账号或密码错误');location.href='/';</script>");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        this.doPost(request,response);
    }
}
