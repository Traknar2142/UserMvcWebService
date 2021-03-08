package ru.diasoft.user_mvc_webservice.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.diasoft.user_mvc_webservice.entities.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setPass(rs.getString("pass"));
        user.setMail(rs.getString("mail"));
        return user;
    }

}
