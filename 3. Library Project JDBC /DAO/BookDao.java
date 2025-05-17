package com.JDBC_project.DAO;

import com.JDBC_project.Entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository       //✅ We are using this with DataBase  instend of Component
public class BookDao
{

    private JdbcTemplate jdbcTemplate;


    //✅ We dont Have to write @Autowired here                  =>✅ Constructor  Injection
    public BookDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Book book)
    {
        String query = "insert into books (title,about,author,language,available) values (?,?,?,?,?)";

        int rowEffected = jdbcTemplate.update(
                query,
                book.getTitle(),
                book.getAbout(),
                book.getAuthor(),
                book.getLanguage(),
                book.getAvailable()
        );

        System.out.println("Book Created = " + rowEffected);

    }

    public void delete(int bookId)
    {
        String query = "delete from books where id = ? ";

        int rowEffected = jdbcTemplate.update(
                query,
                bookId
        );

        System.out.println("Book Created = " + rowEffected);
    }

    public void update(int bookId,Book newBook)
    {
        String query = "update books set title = ? , about = ? , author = ? , language = ? , available = ? where id = ? ";

        int rowEffected = jdbcTemplate.update(
                query,
                newBook.getTitle(),
                newBook.getAbout(),
                newBook.getAuthor(),
                newBook.getLanguage(),
                newBook.getAvailable(),
                bookId
        );

        System.out.println("Book Created = " + rowEffected);
    }

    public Book get(int bookID)
    {
        String query = "Select * from books where id = ? ";

        Book book =  jdbcTemplate.queryForObject(
                query,
                new BookRowMapper(),
                bookID
        );

        return book;
    }

    public List<Book> getAll()
    {
        String query = "select * from books";

        List<Book> books = jdbcTemplate.query(
                query,
                new BookRowMapper()
        );

        return books;
    }

    public List<Book> search(String titlekey)
    {
        String query = "select * from books where title like ? ";

        List<Book> books = jdbcTemplate.query(
                query,
                new BookRowMapper(),
                "%" + titlekey + "%"
        );

        return books;
    }



}
