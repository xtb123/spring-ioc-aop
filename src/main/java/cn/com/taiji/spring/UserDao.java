package cn.com.taiji.spring;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {

    @Transaction(propagate = "new")
    public void save(){
        System.out.println("userDao save()");
    }

    public void update(){
        System.out.println("userDao update()");
    }
}
