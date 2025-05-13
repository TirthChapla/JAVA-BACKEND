package com.dataBase_JDBC.DAO;

import com.dataBase_JDBC.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int userCreate(User user)
    {

        String query = "INSERT INTO user values (?,?,?,?,?,?)";

        int rowAffected = jdbcTemplate.update(query ,
                user.getRollno(),
                user.getName(),
                user.getEmail(),
                user.getMobileno(),
                user.getCity(),
                user.getCountry());

        System.out.println("User Created No: " + rowAffected);
        return rowAffected;
    }
}
