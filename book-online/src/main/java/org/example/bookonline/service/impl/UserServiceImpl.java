package org.example.bookonline.service.impl;

import org.example.bookonline.dao.UserDao;
import org.example.bookonline.dao.impl.UserDaoImpl;
import org.example.bookonline.entity.User;
import org.example.bookonline.service.UserService;

public class UserServiceImpl  implements UserService{
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User signIn(String account,String password){
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }
}
