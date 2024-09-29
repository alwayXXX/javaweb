package org.example.bookonline.service.impl;

import org.example.bookonline.dao.BookDao;
import org.example.bookonline.dao.impl.BookDaoImpl;
import org.example.bookonline.entity.Book;
import org.example.bookonline.service.BookService;


import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}
