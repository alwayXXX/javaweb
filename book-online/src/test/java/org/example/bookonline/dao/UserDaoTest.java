package org.example.bookonline.dao;


import org.example.bookonline.dao.impl.UserDaoImpl;
import org.example.bookonline.entity.User;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
//        userDao.insertUser(User.builder().account("admin").password("123456").nickname("admin").build());//测试数据  //增
//        userDao.insertUser(User.builder().account("user").password("123456").nickname("admin").avatar("111").build());

//        System.out.println(userDao.findUser(User.builder().account("user").password("123456").build())); //查数据  //测试
        userDao.insertUser(User.builder().account("admin1").password("123456").nickname("admin1").build());
    }
}
