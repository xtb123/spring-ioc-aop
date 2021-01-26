package cn.com.taiji.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Scope("prototype")
public interface UserService {

    public void save();

    public void update();

//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    public void save(){
////        System.out.println("UserService save()");
//        Date start=new Date();
//        userDao.save();
//        Date end=new Date();
//        System.out.println(end.getTime()-start.getTime());
//
//    }
}
