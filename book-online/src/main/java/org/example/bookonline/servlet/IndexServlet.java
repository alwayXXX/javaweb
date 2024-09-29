package org.example.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bookonline.entity.Book;
import org.example.bookonline.service.BookService;
import org.example.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        List<Book> bookList = bookService.getBooks();
        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
