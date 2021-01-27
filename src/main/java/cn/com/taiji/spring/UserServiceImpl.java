package cn.com.taiji.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save(){
        //System.out.println(this.getClass());
        System.out.println("UserService save()");
        update();
//        Date start=new Date();
//        userDao.save();
//        Date end=new Date();
//        System.out.println(end.getTime()-start.getTime());

    }

    @Override
    public void update() {
        System.out.println("UserService update()");
    }
}
