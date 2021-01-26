package cn.com.taiji.spring.dao;

import cn.com.taiji.spring.UserDao;
import cn.com.taiji.spring.UserService;

import java.util.Date;

public class ProxyUserDao {

    private UserDao userDao;

    public ProxyUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    public void save(){
        System.out.println("before");
        Date start=new Date();
        userDao.save();
        Date end=new Date();
        System.out.println("after");
        System.out.println(end.getTime()-start.getTime());
    }
}


