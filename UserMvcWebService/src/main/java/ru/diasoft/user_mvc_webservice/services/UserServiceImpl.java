package ru.diasoft.user_mvc_webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.diasoft.user_mvc_webservice.dao.UserDao;
import ru.diasoft.user_mvc_webservice.entities.User;

@Service
public class UserServiceImpl implements UserService{
    
    UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
        
    }

    @Override
    public void update(User user) {
        userDao.update(user);
        
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);        
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

}
