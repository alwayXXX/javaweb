package org.example.bookonline.dao.impl;

import org.example.bookonline.dao.BookDao;
import org.example.bookonline.entity.Book;
import org.example.bookonline.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public List<Book> selectAll() {
        String sql = "SELECT * FROM t_book ORDER BY id DESC";
        return template.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT * FROM t_book WHERE id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
}
