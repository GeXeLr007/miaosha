package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    
    public User getByid(int id){
        return userDao.getByid(id);
    }
    
    public void tx(){
        User user = new User();
        user.setId(1);
        user.setName("abc");
    }
    
}
