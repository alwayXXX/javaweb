package top.soft.class03response.servletContext;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



@WebServlet("/servletContextDemo04")
public class ServletContextDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        String aPath = servletContext.getRealPath("/a.txt");
        System.out.println("a.txt 文件地址" + aPath);


        String bPath = servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println("b.txt 文件地址" + bPath);

        String cPath = servletContext.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println("c.txt 文件地址"+cPath);


        File file = new File(cPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();


    }
}
