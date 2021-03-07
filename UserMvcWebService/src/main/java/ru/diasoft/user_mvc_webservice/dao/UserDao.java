package ru.diasoft.user_mvc_webservice.dao;

import java.util.List;

import ru.diasoft.user_mvc_webservice.entities.User;


public interface UserDao {
    
public void add(User user);
    
    public void update(User user);
    
    public void removeUser(int id);
    
    public User getUserById(int id);
    
    public List<User> getUsersList();

}
