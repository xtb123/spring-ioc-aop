package cn.com.taiji.spring;

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
        System.out.println("UserService save()");
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
