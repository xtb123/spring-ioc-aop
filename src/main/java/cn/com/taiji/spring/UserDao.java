package cn.com.taiji.spring;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void save(){
        System.out.println("userDao save()");
    }
}
