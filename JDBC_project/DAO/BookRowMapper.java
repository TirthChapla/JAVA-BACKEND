package com.JDBC_project.DAO;

import com.JDBC_project.Entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book>
{
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Book book = new Book();

        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAvailable(rs.getBoolean("available"));
        book.setAbout(rs.getString("about"));
        book.setLanguage(rs.getString("language"));

        return book;
    }
}
