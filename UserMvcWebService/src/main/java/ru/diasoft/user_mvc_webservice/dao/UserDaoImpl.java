package ru.diasoft.user_mvc_webservice.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.diasoft.user_mvc_webservice.entities.User;
import ru.diasoft.user_mvc_webservice.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {       
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", user.getName());
        parameters.addValue("pass", user.getPass());
        parameters.addValue("mail", user.getMail());
        String sql = "INSERT INTO t_user(name, pass, mail) VALUES(:name, :pass, :mail)";
        jdbcTemplate.update(sql, parameters);
        
        logger.info("User added\n Details: " + user);
    }

    @Override
    public void update(User user) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", user.getId());
        parameters.addValue("name", user.getName());
        parameters.addValue("pass", user.getPass());
        parameters.addValue("mail", user.getMail());
        String sql = "UPDATE t_user SET name = :name, pass = :pass, mail = :mail WHERE user_id = :id";
        
        jdbcTemplate.update(sql, parameters);
        
        logger.info("User updated\n Details: " + user);
    }

    @Override
    public void removeUser(int id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        String sql = "DELETE FROM t_user WHERE user_id = :id";
        User user = getUserById(id);
        
        if(user != null) {
            jdbcTemplate.update(sql, parameters);
        }
        
        logger.info("User deleted\n Details: " + user);
    }

    @Override
    public User getUserById(int id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        String sql = "SELECT * FROM t_user WHERE user_id=:id";   
        
        User user = jdbcTemplate.queryForObject(sql, parameters, new UserRowMapper());
        
        logger.info("User loaded\n Details: " + user);
        
        return user;
    }

    @Override
    public List<User> getUsersList() {
        String sql = "SELECT * FROM t_user";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        
        for(User user: users) {
            logger.info("User list" + user);
        }
        return users;
    }
}
